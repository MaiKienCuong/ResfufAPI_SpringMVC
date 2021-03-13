package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Nhanvien;
import com.maikiencuong.repository.NhanvienRepository;
import com.maikiencuong.service.NhanvienService;

@Service
public class NhanvienServiceImpl implements NhanvienService {

	@Autowired
	private NhanvienRepository nhanvienRepository;

	public Nhanvien addNhanvien(Nhanvien nhanvien) {
		return nhanvienRepository.saveAndFlush(nhanvien);
	}

	public void delete(String id) {
		nhanvienRepository.delete(id);
	}

	public Nhanvien editNhanvien(Nhanvien nhanvien) {
		return nhanvienRepository.saveAndFlush(nhanvien);
	}

	public Nhanvien getById(String id) {
		return nhanvienRepository.findOne(id);
	}

	public List<Nhanvien> getAll() {
		return nhanvienRepository.findAll().subList(0, 10);
	}

}
