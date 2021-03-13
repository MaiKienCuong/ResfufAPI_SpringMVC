package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Khachhang;

@Repository
public interface KhachhangRepository extends JpaRepository<Khachhang, String> {

	@Query(value = "SELECT TOP 10 * FROM Khachhang", nativeQuery = true)
	public List<Khachhang> top10();

	@Query(value = "SELECT top 1 * FROM Khachhang WHERE sodienthoai = :sdt", nativeQuery = true)
	public Khachhang getByPhone(@Param("sdt") String sdt);

}
