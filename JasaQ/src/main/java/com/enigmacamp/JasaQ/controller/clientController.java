package com.enigmacamp.JasaQ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.ClientRequest;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.services.ClientServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("client")
@Validated
@CrossOrigin(origins = "*")
public class clientController {
	@Autowired
	ClientServices services;
	
	@ApiOperation("Get all user")
	@GetMapping("")
	public List<Client> getAll() {
		return services.getAll();
	}
	
	@ApiOperation("Get by username")
	@GetMapping("search")
	public ClientDto getByUsername(@RequestParam String username, String password) {
		return services.getByUsername(username, password);
	}
	
	@ApiOperation("Get by name")
	@PostMapping
	public ClientDto create(@RequestBody ClientRequest request) {
		return services.create(request);
	}
}
