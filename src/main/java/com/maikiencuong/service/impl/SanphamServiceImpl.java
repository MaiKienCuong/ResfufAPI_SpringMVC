package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Sanpham;
import com.maikiencuong.repository.SanphamRepository;
import com.maikiencuong.service.SanphamService;

@Service
public class SanphamServiceImpl implements SanphamService {

	@Autowired
	private SanphamRepository sanphamRepository;

	public Sanpham addSanpham(Sanpham sanpham) {
		return sanphamRepository.saveAndFlush(sanpham);
	}

	public void delete(String id) {
		sanphamRepository.delete(id);
	}

	public Sanpham editSanpham(Sanpham sanpham) {
		return sanphamRepository.saveAndFlush(sanpham);
	}

	public Sanpham getById(String id) {
		return sanphamRepository.findOne(id);
	}

	public List<Sanpham> getAll() {
		return sanphamRepository.top10();
	}

}
