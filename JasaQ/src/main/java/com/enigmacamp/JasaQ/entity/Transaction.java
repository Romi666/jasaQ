package com.enigmacamp.JasaQ.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "price")
	private Double price;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, Date date, Double price) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
	}

	public Transaction(Date date, Double price) {
		super();
		this.date = date;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
