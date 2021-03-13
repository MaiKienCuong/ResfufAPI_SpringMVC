package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Loaisanpham;
import com.maikiencuong.repository.LoaisanphamRepository;
import com.maikiencuong.service.LoaisanphamService;

@Service
public class LoaisanphamServiceImpl implements LoaisanphamService {

	@Autowired
	private LoaisanphamRepository loaisanphamRepository;

	public Loaisanpham addLoaisanpham(Loaisanpham loaisanpham) {
		return loaisanphamRepository.saveAndFlush(loaisanpham);
	}

	public void delete(String id) {
		loaisanphamRepository.delete(id);
	}

	public Loaisanpham editLoaisanpham(Loaisanpham loaisanpham) {
		return loaisanphamRepository.saveAndFlush(loaisanpham);
	}

	public Loaisanpham getById(String id) {
		return loaisanphamRepository.findOne(id);
	}

	public List<Loaisanpham> getAll() {
		return loaisanphamRepository.top10();
	}

}
