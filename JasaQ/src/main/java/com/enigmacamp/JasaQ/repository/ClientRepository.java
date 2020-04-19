package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findAll();
	
	Client findByUsernameContainsIgnoreCase(String name);
	
	void delete(Client client);
}
