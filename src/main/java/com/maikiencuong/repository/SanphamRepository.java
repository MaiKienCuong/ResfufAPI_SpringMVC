package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Sanpham;

@Repository
public interface SanphamRepository extends JpaRepository<Sanpham, String> {

	@Query(value = "SELECT TOP 10 * FROM Sanpham", nativeQuery = true)
	public List<Sanpham> top10();

}
