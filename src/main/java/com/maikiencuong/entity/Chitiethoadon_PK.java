package com.maikiencuong.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.jsonView.Views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chitiethoadon_PK implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonView(Views.Public.class)
	private String mahoadon;

	@JsonView(Views.Public.class)
	private String masanpham;

}
