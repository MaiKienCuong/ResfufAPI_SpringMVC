package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Hoadon;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.HoadonService;

@RestController
@RequestMapping("/api")
public class HoadonController {

	@Autowired
	private HoadonService hoadonService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/hoadons")
	public ResponseEntity<List<Hoadon>> listAllAnswers() {
		List<Hoadon> hoadons = hoadonService.getAll();
		if (hoadons.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Hoadon>>(hoadons, HttpStatus.OK);
	}

}
