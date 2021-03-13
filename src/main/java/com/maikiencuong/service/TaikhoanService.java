package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Taikhoan;

public interface TaikhoanService {

	public Taikhoan addTaikhoan(Taikhoan taikhoan);

	public void delete(String id);

	public Taikhoan editTaikhoan(Taikhoan taikhoan);

	public Taikhoan getById(String id);

	public List<Taikhoan> getAll();
}
