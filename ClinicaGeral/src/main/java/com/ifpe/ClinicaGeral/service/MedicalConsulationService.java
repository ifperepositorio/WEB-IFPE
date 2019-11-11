package com.ifpe.ClinicaGeral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.ClinicaGeral.model.MedicalConsultation;
import com.ifpe.ClinicaGeral.repository.MedicalConsulations;

@Service
public class MedicalConsulationService {

	@Autowired
	private MedicalConsulations medical;
	
	public void save(MedicalConsultation med) {
		medical.save(med);
	}
	
}
