package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Sanpham;

public interface SanphamService {

	public Sanpham addSanpham(Sanpham sanpham);

	public void delete(String id);

	public Sanpham editSanpham(Sanpham sanpham);

	public Sanpham getById(String id);

	public List<Sanpham> getAll();
}
