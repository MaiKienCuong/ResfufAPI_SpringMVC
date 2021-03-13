package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Khachhang;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.KhachhangService;

@RestController
@RequestMapping("/api")
public class KhachhangController {

	@Autowired
	private KhachhangService khachhangService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/khachhangs")
	public ResponseEntity<List<Khachhang>> listAllAnswers() {
		List<Khachhang> khachhangs = khachhangService.getAll();
		if (khachhangs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Khachhang>>(khachhangs, HttpStatus.OK);
	}
}
