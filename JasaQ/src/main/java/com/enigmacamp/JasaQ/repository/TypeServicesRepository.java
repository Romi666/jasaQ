package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.TypeServices;

public interface TypeServicesRepository extends JpaRepository<TypeServices, Long> {
	List<TypeServices> findAll();
	
	TypeServices findByTypeContainsIgnoreCase(String type);
}
