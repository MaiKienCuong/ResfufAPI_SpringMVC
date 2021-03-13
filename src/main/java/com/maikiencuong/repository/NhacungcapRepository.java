package com.maikiencuong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Nhacungcap;

@Repository
public interface NhacungcapRepository extends JpaRepository<Nhacungcap, String> {

}
