package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Nhanvien;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.NhanvienService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class NhanvienController {

	@Autowired
	private NhanvienService nhanvienService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/nhanviens")
	public ResponseEntity<List<Nhanvien>> listNhanvien() {
		List<Nhanvien> nhanviens = nhanvienService.getAll();
		if (nhanviens.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Nhanvien>>(nhanviens, HttpStatus.OK);
	}
}
