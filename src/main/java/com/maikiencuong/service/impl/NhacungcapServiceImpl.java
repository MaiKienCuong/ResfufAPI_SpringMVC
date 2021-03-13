package com.maikiencuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikiencuong.entity.Nhacungcap;
import com.maikiencuong.repository.NhacungcapRepository;
import com.maikiencuong.service.NhacungcapService;

@Service
public class NhacungcapServiceImpl implements NhacungcapService {

	@Autowired
	private NhacungcapRepository nhacungcapRepository;

	public Nhacungcap addNhacungcap(Nhacungcap nhacungcap) {
		return nhacungcapRepository.saveAndFlush(nhacungcap);
	}

	public void delete(String id) {
		nhacungcapRepository.delete(id);
	}

	public Nhacungcap editNhacungcap(Nhacungcap nhacungcap) {
		return nhacungcapRepository.saveAndFlush(nhacungcap);
	}

	public Nhacungcap getById(String id) {
		return nhacungcapRepository.findOne(id);
	}

	public List<Nhacungcap> getAll() {
		return nhacungcapRepository.top10();
	}

}
