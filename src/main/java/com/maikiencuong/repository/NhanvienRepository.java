package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Nhanvien;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {

}
