package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Loaisanpham;

@Repository
public interface LoaisanphamRepository extends JpaRepository<Loaisanpham, String> {

	@Query(value = "SELECT TOP 10 * FROM Loaisanpham", nativeQuery = true)
	public List<Loaisanpham> top10();
}
