package com.maikiencuong.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maikiencuong.entity.Khachhang;
import com.maikiencuong.jsonView.Views;
import com.maikiencuong.service.KhachhangService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class KhachhangController {

	@Autowired
	private KhachhangService khachhangService;

	/* lay ra 10 khach hang dau tien */
	@JsonView(Views.Public.class)
	@GetMapping("/khachhangs")
	public ResponseEntity<List<Khachhang>> listKhachhang() {
		List<Khachhang> khachhangs = khachhangService.getAll();
		if (!khachhangs.isEmpty()) {
			return new ResponseEntity<List<Khachhang>>(khachhangs, HttpStatus.OK);
		}
		return new ResponseEntity<List<Khachhang>>(HttpStatus.NOT_FOUND);
	}

	/* lay ra khach hang theo ma khach hang */
	@JsonView(Views.Public.class)
	@GetMapping("/khachhang/{id}")
	public ResponseEntity<Khachhang> khachhangById(@PathVariable("id") String id) {
		Khachhang khachhang = khachhangService.getById(id);
		if (khachhang != null) {
			return new ResponseEntity<Khachhang>(khachhang, HttpStatus.OK);
		}
		return new ResponseEntity<Khachhang>(HttpStatus.NOT_FOUND);
	}

	/* lay ra khach hang theo so dien thoai */
	@JsonView(Views.Public.class)
	@GetMapping("/khachhang/sdt/{sdt}")
	public ResponseEntity<Khachhang> khachhangByPhone(@PathVariable("sdt") String sdt) {
		Khachhang khachhang = khachhangService.getByPhone(sdt);
		if (khachhang != null) {
			return new ResponseEntity<Khachhang>(khachhang, HttpStatus.OK);
		}
		return new ResponseEntity<Khachhang>(HttpStatus.NOT_FOUND);
	}

	/* them mot khach hang moiw */
	@JsonView(Views.Public.class)
	@PostMapping("/khachhang")
	public ResponseEntity<Khachhang> addKhachhang(@RequestBody Khachhang khachhang) {
		Khachhang addKhachhang = khachhangService.addKhachhang(khachhang);
		if (addKhachhang != null) {
			return new ResponseEntity<Khachhang>(addKhachhang, HttpStatus.OK);
		}
		return new ResponseEntity<Khachhang>(HttpStatus.NOT_FOUND);
	}

	/* cap nhat mot khach hang cu da co */
	@JsonView(Views.Public.class)
	@PutMapping("/khachhang")
	public ResponseEntity<Khachhang> capnhatKhachhang(@RequestBody Khachhang khachhang) {
		Khachhang updatedKhachhang = khachhangService.editKhachhang(khachhang);
		if (updatedKhachhang != null) {
			return new ResponseEntity<Khachhang>(updatedKhachhang, HttpStatus.OK);
		}
		return new ResponseEntity<Khachhang>(HttpStatus.NOT_FOUND);
	}

	/* xoa khach hang */
	@JsonView(Views.Public.class)
	@DeleteMapping("/khachhang/{id}")
	public ResponseEntity<String> xoaKhachhang(@PathVariable("id") String id) {
		System.out.println(id);
		khachhangService.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
