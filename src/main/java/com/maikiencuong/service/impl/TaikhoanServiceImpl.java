package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Taikhoan;
import com.maikiencuong.repository.TaikhoanRepository;
import com.maikiencuong.service.TaikhoanService;

@Service
public class TaikhoanServiceImpl implements TaikhoanService {

	@Autowired
	private TaikhoanRepository taikhoanRepository;

	public Taikhoan addTaikhoan(Taikhoan taikhoan) {
		return taikhoanRepository.saveAndFlush(taikhoan);
	}

	public void delete(String id) {
		taikhoanRepository.delete(id);
	}

	public Taikhoan editTaikhoan(Taikhoan taikhoan) {
		return taikhoanRepository.saveAndFlush(taikhoan);
	}

	public Taikhoan getById(String id) {
		return taikhoanRepository.findOne(id);
	}

	public List<Taikhoan> getAll() {
		return taikhoanRepository.findAll();
	}

}
