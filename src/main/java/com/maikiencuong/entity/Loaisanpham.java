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

@Table(name = "Loaisanpham")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "maloai")
public class Loaisanpham {

	@Column(name = "maloai")
	@JsonView(Views.Public.class)
	private @Id String maloai;

	@Column(name = "tenloai", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String tenloai;

	@ToString.Exclude
	@OneToMany(mappedBy = "loaisanpham", fetch = FetchType.LAZY)
	private List<Sanpham> sanphams;

	public Loaisanpham(String maloai) {
		super();
		this.maloai = maloai;
	}

	public Loaisanpham(String maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}

}
