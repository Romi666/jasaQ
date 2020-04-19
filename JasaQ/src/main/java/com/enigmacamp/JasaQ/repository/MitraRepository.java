package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.Mitra;

public interface MitraRepository extends JpaRepository<Mitra, Long> {
	List<Mitra> findAll();
	
	Mitra findByNameContainsIgnoreCase(String name);
	
}
