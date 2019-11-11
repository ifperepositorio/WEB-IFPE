package com.ifpe.ClinicaGeral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.ClinicaGeral.model.Patient;
import com.ifpe.ClinicaGeral.repository.Patients;

@Service
public class PatientService {

	@Autowired
	private Patients patients;
	
	public void save(Patient patient) {
		patients.save(patient);
	}
}
