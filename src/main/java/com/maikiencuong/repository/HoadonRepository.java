package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Hoadon;

@Repository
public interface HoadonRepository extends JpaRepository<Hoadon, String> {

	@Query(value = "SELECT TOP 10 * FROM Hoadon", nativeQuery = true)
	public List<Hoadon> top10();

	@Query(value = "SELECT * FROM Hoadon h JOIN Nhanvien n ON n.manhanvien = h.manhanvien WHERE h.manhanvien = :id", nativeQuery = true)
	public List<Hoadon> getByIdNhanvien(@Param("id") String id);

	@Query(value = "SELECT * FROM Hoadon h JOIN Khachhang k ON k.makhachhang = h.makhachhang WHERE h.makhachhang= :id", nativeQuery = true)
	public List<Hoadon> getByIdKhachhang(@Param("id") String id);

}
