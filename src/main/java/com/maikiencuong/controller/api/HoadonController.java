package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Hoadon;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.HoadonService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class HoadonController {

	@Autowired
	private HoadonService hoadonService;

	@JsonView(Views.Public.class)
	@GetMapping("/hoadons")
	/* lay ra 10 hoa don dau tien */
	public ResponseEntity<List<Hoadon>> listHoadon() {
		List<Hoadon> hoadons = hoadonService.getAll();
		if (!hoadons.isEmpty()) {
			return new ResponseEntity<List<Hoadon>>(hoadons, HttpStatus.OK);
		}
		return new ResponseEntity<List<Hoadon>>(HttpStatus.NOT_FOUND);
	}

	@JsonView(Views.Public.class)
	@GetMapping("/hoadon/{id}")
	/* lay ra hoa don theo ma hoa don */
	public ResponseEntity<Hoadon> hoadonById(@PathVariable("id") String id) {
		Hoadon hoadon = hoadonService.getById(id);
		if (hoadon != null) {
			return new ResponseEntity<Hoadon>(hoadon, HttpStatus.OK);
		}
		return new ResponseEntity<Hoadon>(HttpStatus.NOT_FOUND);
	}

	@JsonView(Views.Public.class)
	@GetMapping("/hoadon/nhanvien/{id}")
	/* lay ra hoa don theo ma nhan vien */
	public ResponseEntity<List<Hoadon>> hoadonByIdNhanvien(@PathVariable("id") String id) {
		List<Hoadon> hoadons = hoadonService.getByIdNhanvien(id);
		if (!hoadons.isEmpty()) {
			return new ResponseEntity<List<Hoadon>>(hoadons, HttpStatus.OK);
		}
		return new ResponseEntity<List<Hoadon>>(HttpStatus.NOT_FOUND);
	}

	@JsonView(Views.Public.class)
	@GetMapping("/hoadon/khachhang/{id}")
	/* lay ra hoa don theo ma nhan vien */
	public ResponseEntity<List<Hoadon>> hoadonByIdKhachhang(@PathVariable("id") String id) {
		List<Hoadon> hoadons = hoadonService.getByIdKhachhang(id);
		if (!hoadons.isEmpty()) {
			return new ResponseEntity<List<Hoadon>>(hoadons, HttpStatus.OK);
		}
		return new ResponseEntity<List<Hoadon>>(HttpStatus.NOT_FOUND);
	}

}
