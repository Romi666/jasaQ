package com.enigmacamp.JasaQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
