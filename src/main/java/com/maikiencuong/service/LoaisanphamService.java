package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Loaisanpham;

public interface LoaisanphamService {

	public Loaisanpham addLoaisanpham(Loaisanpham loaisanpham);

	public void delete(String id);

	public Loaisanpham editLoaisanpham(Loaisanpham loaisanpham);

	public Loaisanpham getById(String id);

	public List<Loaisanpham> getAll();
}
