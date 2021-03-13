package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Hoadon;
import com.maikiencuong.repository.HoadonRepository;
import com.maikiencuong.service.HoadonService;

@Service
public class HoadonServiceImpl implements HoadonService {

	@Autowired
	private HoadonRepository hoadonRepository;

	public Hoadon addHoadon(Hoadon hoadon) {
		return hoadonRepository.saveAndFlush(hoadon);
	}

	public void delete(String id) {
		hoadonRepository.delete(id);
	}

	public Hoadon editHoadon(Hoadon hoadon) {
		return hoadonRepository.saveAndFlush(hoadon);
	}

	public Hoadon getById(String id) {
		return hoadonRepository.findOne(id);
	}

	public List<Hoadon> getAll() {
		return hoadonRepository.top10();
	}

	public List<Hoadon> getByIdNhanvien(String id) {
		return hoadonRepository.getByIdNhanvien(id);
	}

	public List<Hoadon> getByIdKhachhang(String id) {
		return hoadonRepository.getByIdKhachhang(id);
	}

}
