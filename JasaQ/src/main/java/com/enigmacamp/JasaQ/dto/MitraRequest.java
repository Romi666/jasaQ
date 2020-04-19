package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class MitraRequest {
	
	@NotEmpty(message = "nama tidak boleh kosong")
	private String name;
	
	@NotEmpty(message = "username tidak boleh kosong")
	private String username;
	
	@NotEmpty(message = "password tidak boleh kosong")
	private String password;
	
	@NotEmpty(message = "email tidak boleh kosong")
	private String email;
	
	@NotEmpty(message = "Photo profile tidak boleh kosong")
	private String photoProfile;
	
	@NotEmpty(message = "No HP tidak boleh kosong")
	private String noHp;
	
	@NotEmpty(message = "alamat tidak boleh kosong")
	private String alamat;
	
	@NotEmpty(message = "Pelayanan tidak boleh kosong")
	private String servicesMitra;
	
	@NotNull
	private Double servicesPrice;
	
	
	

	public MitraRequest(@NotEmpty(message = "nama tidak boleh kosong") String name,
			@NotEmpty(message = "username tidak boleh kosong") String username,
			@NotEmpty(message = "password tidak boleh kosong") String password,
			@NotEmpty(message = "email tidak boleh kosong") String email,
			@NotEmpty(message = "Photo profile tidak boleh kosong") String photoProfile,
			@NotEmpty(message = "No HP tidak boleh kosong") String noHp,
			@NotEmpty(message = "alamat tidak boleh kosong") String alamat,
			@NotEmpty(message = "Pelayanan tidak boleh kosong") String servicesMitra,
			@NotNull Double servicesPrice) 
	{
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.noHp = noHp;
		this.alamat = alamat;
		this.servicesMitra = servicesMitra;
		this.servicesPrice = servicesPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoProfile() {
		return photoProfile;
	}

	public void setPhotoProfile(String photoProfile) {
		this.photoProfile = photoProfile;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getServicesMitra() {
		return servicesMitra;
	}

	public void setServicesMitra(String servicesMitra) {
		this.servicesMitra = servicesMitra;
	}

	public Double getServicesPrice() {
		return servicesPrice;
	}

	public void setServicesPrice(Double servicesPrice) {
		this.servicesPrice = servicesPrice;
	}
}
