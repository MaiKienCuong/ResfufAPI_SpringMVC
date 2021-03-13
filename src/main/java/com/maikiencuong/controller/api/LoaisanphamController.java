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
import com.maikiencuong.entity.Loaisanpham;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.LoaisanphamService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoaisanphamController {

	@Autowired
	private LoaisanphamService loaisanphamService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/loaisanphams")
	public ResponseEntity<List<Loaisanpham>> listAllAnswers() {
		List<Loaisanpham> loaisanphams = loaisanphamService.getAll();
		if (loaisanphams.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Loaisanpham>>(loaisanphams, HttpStatus.OK);
	}
}
