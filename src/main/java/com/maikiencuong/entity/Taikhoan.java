package com.maikiencuong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "Taikhoan")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = { "tendangnhap", "matkhau" })
public class Taikhoan {

	@Column(name = "tendangnhap")
	@JsonView(Views.Public.class)
	private @Id String tendangnhap;

	@Column(name = "matkhau", nullable = false)
	@JsonView(Views.Public.class)
	private String matkhau;

	@OneToOne
	@PrimaryKeyJoinColumn
	@MapsId("manhanvien")
	@ToString.Exclude
	private Nhanvien nhanvien;

	public Taikhoan(String tendangnhap, String matkhau) {
		super();
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}

}
