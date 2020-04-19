package com.enigmacamp.JasaQ.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.ClientRequest;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.repository.ClientRepository;

@Service
public class ClientServices {
	@Autowired
	ClientRepository repo;
	
	
	public ClientDto convertClientDto(Client client) {
		ModelMapper modelMapper = new ModelMapper();
		ClientDto dto = modelMapper.map(client, ClientDto.class);
		return dto;
	}
	
	public Client convertClient(ClientDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Client client = modelMapper.map(dto, Client.class);
		return client;
	}
	
	public ClientDto create(ClientRequest request) {
		Client client = new Client(request.getName(), request.getUsername(), request.getPassword(), request.getPhotoProfile(), request.getEmail(), request.getNoHp(), request.getAlamat(), 0.0, Role.CLIENT);
		ClientDto dto = convertClientDto(client);
		repo.save(client);
		return dto;
	}
	
	public ClientDto getByUsername(String username, String password) {
		List<Client> client = repo.findAll();
		Client client1 = null;
		for (Client client2 : client) {
			if(client2.getUsername().equals(username)&& client2.getPassword().equals(password)) {
				client1 = client2;
				
			}
		}
		return convertClientDto(client1);
	}
	
	public List<Client> getAll() {
		return repo.findAll();
	}

}
