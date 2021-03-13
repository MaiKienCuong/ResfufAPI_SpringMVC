package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Nhanvien;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {

	@Query(value = "SELECT TOP 10 * FROM Nhanvien", nativeQuery = true)
	public List<Nhanvien> top10();

}
