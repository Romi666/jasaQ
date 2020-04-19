package com.enigmacamp.JasaQ.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.ServiceMitraDto;
import com.enigmacamp.JasaQ.dto.ServicesMitraRequest;
import com.enigmacamp.JasaQ.dto.TypeServicesDto;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.entity.TypeServices;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.ServicesMitraRepository;

@Service
public class MitraServicesServices {
	
	@Autowired
	ServicesMitraRepository repo;
	
	@Autowired
	TypeServicesServices typeServ;
	
	public ServiceMitraDto convertDto(ServicesMitra servMitra) {
		ModelMapper modelMapper = new ModelMapper();
		ServiceMitraDto dto = modelMapper.map(servMitra, ServiceMitraDto.class);
		return dto;
	}
	
	public ServicesMitra convertEntity(ServiceMitraDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		ServicesMitra servMitra = modelMapper.map(dto, ServicesMitra.class);
		return servMitra;
	}
	
	public ServiceMitraDto create(ServicesMitraRequest request) {
		TypeServicesDto dtoType = typeServ.findByTypeContainsIgnoreCase(request.getType());
		TypeServices type = typeServ.convertEntity(dtoType);
		ServicesMitra servMitra = new ServicesMitra(request.getServicesName(), request.getLogo(), type);
		repo.save(servMitra);
		return convertDto(servMitra);
		
	}
	
	public ServiceMitraDto getByName(String name) {
		ServicesMitra check = repo.findByServicesNameContainsIgnoreCase(name);
		if(check==null) {
			throw new NotFoundException("Service " + name + " tidak ada");
		}
		return convertDto(check);
	}
	
	public List<ServicesMitra> getByType(String type) {
		TypeServicesDto typeDto = typeServ.findByTypeContainsIgnoreCase(type);
		List<ServicesMitra> mitraList = repo.findAll();
		List<ServicesMitra> newList = new ArrayList<ServicesMitra>();
		for (ServicesMitra servicesMitra : mitraList) {
			if(servicesMitra.getServicesMitra().getType()==typeDto.getType()) {
				newList.add(servicesMitra);
			}
		}
		return newList;
	}
	
	public List<ServicesMitra> getAll() {
		return repo.findAll();
	}
}
