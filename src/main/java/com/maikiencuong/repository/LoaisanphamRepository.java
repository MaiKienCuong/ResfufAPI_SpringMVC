package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Loaisanpham;

@Repository
public interface LoaisanphamRepository extends JpaRepository<Loaisanpham, String> {

}
