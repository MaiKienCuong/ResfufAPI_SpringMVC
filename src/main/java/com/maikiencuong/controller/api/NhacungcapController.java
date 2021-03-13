package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Nhacungcap;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.NhacungcapService;

@RestController
@RequestMapping("/api")
public class NhacungcapController {

	@Autowired
	private NhacungcapService nhacungcapService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@JsonView(Views.Public.class)
	@GetMapping("/nhacungcaps")
	public ResponseEntity<List<Nhacungcap>> listAllAnswers() {
		List<Nhacungcap> nhacungcaps = nhacungcapService.getAll();
		if (nhacungcaps.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Nhacungcap>>(nhacungcaps, HttpStatus.OK);
	}
}
