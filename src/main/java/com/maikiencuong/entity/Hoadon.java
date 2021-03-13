package com.maikiencuong.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Hoadon")
@Entity
@Data
@EqualsAndHashCode(of = "mahoadon")
public class Hoadon {

	@Column(name = "mahoadon")
	@JsonView(Views.Public.class)
	private @Id String mahoadon;

	@ManyToOne
	@JoinColumn(name = "makhachhang")
	@ToString.Exclude
	private Khachhang khachhang;

	@ManyToOne
	@JoinColumn(name = "manhanvien")
	@ToString.Exclude
	private Nhanvien nhanvien;

	@ToString.Exclude
	@Setter(AccessLevel.PROTECTED)
	@Column(name = "tongtien")
	@JsonView(Views.Public.class)
	private double tongtien;

	@Column(name = "ngaylap", nullable = false)
	@JsonView(Views.Public.class)
	private Date ngaylap;

	@ToString.Exclude
	@OneToMany(mappedBy = "hoadon", fetch = FetchType.LAZY)
	private List<Chitiethoadon> chitiethoadons;

	public double tinhTongtien() {
		tongtien = 0;
		for (Chitiethoadon cthd : chitiethoadons) {
			tongtien += cthd.tinhThanhTien();
		}
		return tongtien;
	}

	public Hoadon() {
		chitiethoadons = new ArrayList<Chitiethoadon>();
		ngaylap = new Date(new java.util.Date().getTime());
	}

	public Hoadon(String mahoadon) {
		this();
		this.mahoadon = mahoadon;
	}

	public Hoadon(String mahoadon, Khachhang khachhang, Nhanvien nhanvien) {
		this();
		this.mahoadon = mahoadon;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
	}

}
