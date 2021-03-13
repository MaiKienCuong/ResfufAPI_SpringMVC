package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Sanpham;

@Repository
public interface SanphamRepository extends JpaRepository<Sanpham, String> {

}
