package com.maikiencuong.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Chitiethoadon")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "pk")
public class Chitiethoadon {

	@EmbeddedId
	@JsonView(Views.Public.class)
	private Chitiethoadon_PK pk;

	@Column(name = "soluong", nullable = false)
	@JsonView(Views.Public.class)
	private int soluong;

	@Column(name = "dongia", nullable = false)
	@Setter(AccessLevel.PROTECTED)
	@JsonView(Views.Public.class)
	private double dongia;

	@ManyToOne
	@JoinColumn(name = "mahoadon")
	@MapsId("mahoadon")
	private Hoadon hoadon;

	@ManyToOne
	@JoinColumn(name = "masanpham")
	@MapsId("masanpham")
	private Sanpham sanpham;

	public double tinhThanhTien() {
		return dongia * soluong;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
		dongia = sanpham.getGiaban() * (1 + sanpham.getThue());
	}

	public Chitiethoadon(int soluong, Hoadon hoadon, Sanpham sanpham) {
		super();
		this.soluong = soluong;
		this.hoadon = hoadon;
		this.sanpham = sanpham;
		pk.setMahoadon(hoadon.getMahoadon());
		pk.setMasanpham(sanpham.getMasanpham());
		dongia = sanpham.getGiaban() * (1 + sanpham.getThue());
	}

}