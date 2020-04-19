package com.enigmacamp.JasaQ.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.MitraRequest;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.services.MitraServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("mitra")
@Validated
@CrossOrigin(origins = "*")
public class MitraController {
	@Autowired
	MitraServices services;
	
	@ApiOperation("create")
	@PostMapping("")
	public MitraDto create(@Valid @RequestBody MitraRequest request) {
		return services.create(request);
	}
	
	@ApiOperation("login mitra")
	@GetMapping("/login")
	public MitraDto loginMitra(@Valid @RequestParam String username, String password) {
		return services.getMitraByUsernameAndPassword(username, password);
	}
	
	@ApiOperation("Get all mitra")
	@GetMapping("")
	public List<Mitra> getAll(){
		return services.getAll();
	}
	
	@ApiOperation("Get by services mitra")
	@GetMapping("/byService")
	public List<Mitra> getByServicesMitra(@Valid @RequestParam String name){
		return services.getByServicesMitra(name);
	}
}
