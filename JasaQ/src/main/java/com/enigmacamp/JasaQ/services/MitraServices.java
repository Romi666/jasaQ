package com.enigmacamp.JasaQ.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.MitraRequest;
import com.enigmacamp.JasaQ.dto.ServiceMitraDto;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;
import com.enigmacamp.JasaQ.repository.MitraRepository;

@Service
public class MitraServices {
	
	@Autowired
	MitraRepository repo;
	
	@Autowired
	MitraServicesServices mitraServ;
	
	public MitraDto convertDto(Mitra mitra) {
		ModelMapper modelMapper = new ModelMapper();
		MitraDto dto = modelMapper.map(mitra, MitraDto.class);
		return dto;
	}
	
	public Mitra convertMitra(MitraDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Mitra mitra = modelMapper.map(dto, Mitra.class);
		return mitra;
	}
	
	public MitraDto create(MitraRequest request) {
	ServiceMitraDto dtoServMitra = mitraServ.getByName(request.getServicesMitra());
	ServicesMitra servicesMitra = mitraServ.convertEntity(dtoServMitra);
	Mitra mitra = new Mitra(request.getName(), request.getUsername(), request.getPassword(), request.getEmail(),
			request.getPhotoProfile(), Status.AVAILABLE, 
			request.getNoHp(), request.getAlamat(), 0.0, Role.MITRA, servicesMitra, request.getServicesPrice());
	repo.save(mitra);
	return convertDto(mitra);
	}
	
	public List<Mitra> getAll() {
		return repo.findAll();
	}
	
	public MitraDto getMitraByUsernameAndPassword(String username, String password) {
		List<Mitra> mitra = getAll();
		Mitra mitra1 = null;
		for (Mitra mitra2 : mitra) {
			if(mitra2.getUsername().equals(username) && mitra2.getPassword().equals(password)) {
				mitra1 = mitra2;
			}
		}
		
		return convertDto(mitra1);
	}
	
	public List<Mitra> getByServicesMitra(String servicesType) {
		List<Mitra> mitra = getAll();
		List<Mitra> newMitra = new ArrayList<Mitra>();
		for (Mitra mitra2 : mitra) {
			if(mitra2.getServicesMitra().getServicesName().contains(servicesType)) {
				newMitra.add(mitra2);
			}
		}
		
		return newMitra;
	}
}
