package com.maikiencuong.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "Nhanvien")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "manhanvien")
public class Nhanvien {

	@Column(name = "manhanvien")
	@JsonView(Views.Public.class)
	private @Id String manhanvien;

	@Column(name = "hodem", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String hodem;

	@Column(name = "ten", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String ten;

	@Column(name = "diachi", columnDefinition = "nvarchar(255)")
	@JsonView(Views.Public.class)
	private String diachi;

	@Column(name = "chucvu", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String chucvu;

	@Column(name = "socmnd", columnDefinition = "nvarchar(60) not null")
	@JsonView(Views.Public.class)
	private String socmnd;

	@Column(name = "sodienthoai")
	@JsonView(Views.Public.class)
	private String sodienthoai;

	@Column(name = "ngaysinh")
	@JsonView(Views.Public.class)
	private Date ngaysinh;

	@Column(name = "gioitinh")
	@JsonView(Views.Public.class)
	private boolean gioitinh;

	@ToString.Exclude
	@OneToOne(mappedBy = "nhanvien")
	private Taikhoan taikhoan;

	@ToString.Exclude
	@OneToMany(mappedBy = "nhanvien", fetch = FetchType.LAZY)
	private List<Hoadon> hoadons;

	public Nhanvien(String manhanvien) {
		super();
		this.manhanvien = manhanvien;
	}

	public Nhanvien(String manhanvien, String hodem, String ten, String socmnd) {
		super();
		this.manhanvien = manhanvien;
		this.hodem = hodem;
		this.ten = ten;
		this.socmnd = socmnd;
	}

}