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
import com.maikiencuong.entity.Sanpham;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.SanphamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class SanphamController {

	@Autowired
	private SanphamService sanphamService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/sanphams")
	public ResponseEntity<List<Sanpham>> listAllAnswers() {
		List<Sanpham> sanphams = sanphamService.getAll();
		if (sanphams.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Sanpham>>(sanphams, HttpStatus.OK);
	}
}
