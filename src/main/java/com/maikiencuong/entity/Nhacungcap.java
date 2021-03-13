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

@Table(name = "Nhacungcap")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "manhacungcap")
public class Nhacungcap {

	@Column(name = "manhacungcap")
	@JsonView(Views.Public.class)
	private @Id String manhacungcap;

	@Column(name = "tennhacungcap", columnDefinition = "nvarchar(255) not null")
	@JsonView(Views.Public.class)
	private String tennhacungcap;

	@Column(name = "email", columnDefinition = "nvarchar(255)")
	@JsonView(Views.Public.class)
	private String email;

	@Column(name = "diachi", columnDefinition = "nvarchar(255)")
	@JsonView(Views.Public.class)
	private String diachi;

	@ToString.Exclude
	@OneToMany(mappedBy = "nhacungcap", fetch = FetchType.LAZY)
	private List<Sanpham> sanphams;

	public Nhacungcap(String manhacungcap) {
		super();
		this.manhacungcap = manhacungcap;
	}

	public Nhacungcap(String manhacungcap, String tennhacungcap) {
		super();
		this.manhacungcap = manhacungcap;
		this.tennhacungcap = tennhacungcap;
	}

	public Nhacungcap(String manhacungcap, String tennhacungcap, String email, String diachi) {
		super();
		this.manhacungcap = manhacungcap;
		this.tennhacungcap = tennhacungcap;
		this.email = email;
		this.diachi = diachi;
	}

}
