package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Hoadon;

@Repository
public interface HoadonRepository extends JpaRepository<Hoadon, String> {
	
	@Query(value = "SELECT TOP 10 * FROM Hoadon", nativeQuery = true)
	public List<Hoadon> top10();

}
