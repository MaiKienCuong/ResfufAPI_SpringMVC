package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Hoadon;

public interface HoadonService {

	public Hoadon addHoadon(Hoadon hoadon);

	public void delete(String id);

	public Hoadon editHoadon(Hoadon hoadon);

	public Hoadon getById(String id);

	public List<Hoadon> getAll();

	public List<Hoadon> getByIdNhanvien(String id);

	public List<Hoadon> getByIdKhachhang(String id);

}
