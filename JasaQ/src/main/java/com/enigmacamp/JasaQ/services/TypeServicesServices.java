package com.enigmacamp.JasaQ.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.TypeServicesDto;
import com.enigmacamp.JasaQ.dto.TypeServicesRequest;
import com.enigmacamp.JasaQ.entity.TypeServices;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.TypeServicesRepository;

@Service
public class TypeServicesServices {
	@Autowired
	TypeServicesRepository repo;
	
	public TypeServicesDto convertDto(TypeServices type) {
		ModelMapper modelMapper = new ModelMapper();
		TypeServicesDto dto = modelMapper.map(type, TypeServicesDto.class);
		return dto;
	}
	
	public TypeServices convertEntity(TypeServicesDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		TypeServices type = modelMapper.map(dto, TypeServices.class);
		return type;
	}
	
	public TypeServicesDto create(TypeServicesRequest request) {
		TypeServices check = repo.findByTypeContainsIgnoreCase(request.getType());
		if(check!=null) {
			throw new NotFoundException("Type " + request.getType() + " already exist");
		}
		TypeServices newType = new TypeServices(request.getType());
		repo.save(newType);
		return convertDto(newType);
	}
	
	public List<TypeServices> getAll() {
		return repo.findAll();
	}
	
	public TypeServicesDto findByTypeContainsIgnoreCase(String type) {
		TypeServices typeServices = repo.findByTypeContainsIgnoreCase(type);
		return convertDto(typeServices);
	}
	
	public Optional<TypeServices> findById(Long id) {
		Optional<TypeServices> check = repo.findById(id);
		if(check==null) {
			throw new NotFoundException("Not found");
		}
		return check;
	}
	
}
