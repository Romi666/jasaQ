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

import com.enigmacamp.JasaQ.dto.ServiceMitraDto;
import com.enigmacamp.JasaQ.dto.ServicesMitraRequest;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.services.MitraServicesServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("mitraServices")
@Validated
@CrossOrigin(origins = "*")
public class MitraServicesController {
	@Autowired
	MitraServicesServices services;
	
	@ApiOperation(value = "Create layanan")
	@PostMapping("")
	public ServiceMitraDto create(@Valid @RequestBody ServicesMitraRequest request) {
		return services.create(request);
	}
	
	@ApiOperation(value = "Get All")
	@GetMapping("")
	public List<ServicesMitra> getAll() {
		return services.getAll();
	}
	
	@ApiOperation(value = "Get by type")
	@GetMapping("/type")
	public List<ServicesMitra> getByType(@Valid @RequestParam String type) {
		return services.getByType(type);
	}
	
	@ApiOperation(value = "Get by name")
	@GetMapping("/search")
	public ServiceMitraDto getByName(@Valid @RequestParam String name) {
		return services.getByName(name);
	}
}
