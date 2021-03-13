package com.maikiencuong.service;

import java.util.List;

import com.maikiencuong.entity.Nhacungcap;

public interface NhacungcapService {

	public Nhacungcap addNhacungcap(Nhacungcap nhacungcap);

	public void delete(String id);

	public Nhacungcap editNhacungcap(Nhacungcap nhacungcap);

	public Nhacungcap getById(String id);

	public List<Nhacungcap> getAll();
}
