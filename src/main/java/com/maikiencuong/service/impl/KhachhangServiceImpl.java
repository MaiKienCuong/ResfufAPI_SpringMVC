package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Khachhang;
import com.maikiencuong.repository.KhachhangRepository;
import com.maikiencuong.service.KhachhangService;

@Service
public class KhachhangServiceImpl implements KhachhangService {

	@Autowired
	private KhachhangRepository khachhangRepository;

	public Khachhang addKhachhang(Khachhang khachhang) {
		return khachhangRepository.saveAndFlush(khachhang);
	}

	public void delete(String id) {
		khachhangRepository.delete(id);
	}

	public Khachhang editKhachhang(Khachhang khachhang) {
		return khachhangRepository.saveAndFlush(khachhang);
	}

	public Khachhang getById(String id) {
		return khachhangRepository.findOne(id);
	}

	public List<Khachhang> getAll() {
		return khachhangRepository.top10();
	}

	public Khachhang getByPhone(String sdt) {
		return khachhangRepository.getByPhone(sdt);
	}

}
