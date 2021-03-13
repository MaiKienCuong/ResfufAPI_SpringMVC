package com.maikiencuong.entity;

import java.sql.Date;
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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "Sanpham")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "masanpham")
public class Sanpham {

	@Column(name = "masanpham")
	@JsonView(Views.Public.class)
	private @Id String masanpham;

	@Column(name = "tensanpham", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String tensanpham;

	@Column(name = "mota", columnDefinition = "nvarchar(1000)")
	@JsonView(Views.Public.class)
	private String mota;

	@Column(name = "mausac", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String mausac;

	@Column(name = "thuonghieu", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String thuonghieu;

	@Column(name = "donvitinh", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String donvitinh;

	@Column(name = "kichthuoc", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String kichthuoc;

	@Column(name = "khoiluong", columnDefinition = "nvarchar(60)")
	@JsonView(Views.Public.class)
	private String khoiluong;

	@Column(name = "xuatxu", columnDefinition = "nvarchar(255)")
	@JsonView(Views.Public.class)
	private String xuatxu;

	@Column(name = "thue")
	@JsonView(Views.Public.class)
	private double thue;

	@Column(name = "giaban", nullable = false)
	@JsonView(Views.Public.class)
	private double giaban;

	@Column(name = "soluongton", nullable = false)
	@JsonView(Views.Public.class)
	private int soluongton;

	@Column(name = "hinhanh")
	@JsonView(Views.Public.class)
	private String hinhanh;

	@Column(name = "ngaynhap")
	@JsonView(Views.Public.class)
	private Date ngaynhap;

	@Column(name = "giamua", nullable = false)
	@JsonView(Views.Public.class)
	private double giamua;

	@Column(name = "thoigianbaohanh")
	@JsonView(Views.Public.class)
	private int thoigianbaohanh;

	@Column(name = "ngungkinhdoanh")
	@JsonView(Views.Public.class)
	private boolean ngungkinhdoanh = false;

	@ManyToOne
	@JoinColumn(name = "maloai")
	@ToString.Exclude
	private Loaisanpham loaisanpham;

	@ManyToOne
	@JoinColumn(name = "manhacungcap")
	@ToString.Exclude
	private Nhacungcap nhacungcap;

	@ToString.Exclude
	@OneToMany(mappedBy = "sanpham", fetch = FetchType.LAZY)
	private List<Chitiethoadon> chitiethoadons;

	public Sanpham(String masanpham) {
		super();
		this.masanpham = masanpham;
	}

	public Sanpham(String masanpham, String tensanpham, double giaban, int soluongton, double giamua) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		this.soluongton = soluongton;
		this.giamua = giamua;
	}

}
