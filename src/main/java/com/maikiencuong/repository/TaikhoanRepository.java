package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Taikhoan;

@Repository
public interface TaikhoanRepository extends JpaRepository<Taikhoan, String> {

	@Query(value = "SELECT TOP 10 * FROM Taikhoan", nativeQuery = true)
	public List<Taikhoan> top10();

}
