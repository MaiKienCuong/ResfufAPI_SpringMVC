package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Khachhang;

@Repository
public interface KhachhangRepository extends JpaRepository<Khachhang, String> {

}
