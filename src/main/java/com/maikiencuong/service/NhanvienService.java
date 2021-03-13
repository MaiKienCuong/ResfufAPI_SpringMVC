package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Nhanvien;

public interface NhanvienService {

	public Nhanvien addNhanvien(Nhanvien nhanvien);

	public void delete(String id);

	public Nhanvien editNhanvien(Nhanvien nhanvien);

	public Nhanvien getById(String id);

	public List<Nhanvien> getAll();
}
