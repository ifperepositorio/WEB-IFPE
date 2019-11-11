package com.ifpe.ClinicaGeral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.ClinicaGeral.model.Especialty;
import com.ifpe.ClinicaGeral.repository.Especialtys;

@Service
public class EspecialtyService {

	@Autowired
	private Especialtys especialtys;
	
	public void save(Especialty especialty) {
		especialtys.save(especialty);
	}
}
