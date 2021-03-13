package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Chitiethoadon;
import com.maikiencuong.entity.Chitiethoadon_PK;

@Repository
public interface ChitiethoadonRepository extends JpaRepository<Chitiethoadon, Chitiethoadon_PK> {

}
