package com.maikiencuong.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "Khachhang")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "makhachhang")
public class Khachhang {

	@Column(name = "makhachhang")
	@JsonView(Views.Public.class)
	private @Id String makhachhang;

	@Column(name = "hoten", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String hoten;

	@Column(name = "diachi", columnDefinition = "nvarchar(255)")
	@JsonView(Views.Public.class)
	private String diachi;

	@Column(name = "sodienthoai")
	@JsonView(Views.Public.class)
	private String sodienthoai;

	@ToString.Exclude
	@OneToMany(mappedBy = "khachhang", fetch = FetchType.LAZY)
	private List<Hoadon> hoadons;

	public Khachhang(String makhachhang) {
		super();
		this.makhachhang = makhachhang;
	}

	public Khachhang(String makhachhang, String hoten) {
		super();
		this.makhachhang = makhachhang;
		this.hoten = hoten;
	}

	public Khachhang(String makhachhang, String hoten, String diachi, String sodienthoai) {
		super();
		this.makhachhang = makhachhang;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
	}

}