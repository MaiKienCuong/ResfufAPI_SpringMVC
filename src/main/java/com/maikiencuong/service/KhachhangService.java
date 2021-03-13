package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Khachhang;

public interface KhachhangService {

	public Khachhang addKhachhang(Khachhang khachhang);

	public void delete(String id);

	public Khachhang editKhachhang(Khachhang khachhang);

	public Khachhang getById(String id);

	public List<Khachhang> getAll();
}
