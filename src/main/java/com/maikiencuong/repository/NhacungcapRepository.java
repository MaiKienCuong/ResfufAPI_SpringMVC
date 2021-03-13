package com.maikiencuong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikiencuong.entity.Nhacungcap;

@Repository
public interface NhacungcapRepository extends JpaRepository<Nhacungcap, String> {

	@Query(value = "SELECT TOP 10 * FROM Nhacungcap", nativeQuery = true)
	public List<Nhacungcap> top10();

}
