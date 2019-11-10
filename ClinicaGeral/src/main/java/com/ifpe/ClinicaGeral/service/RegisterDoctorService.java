package com.ifpe.ClinicaGeral.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.ClinicaGeral.model.Doctor;
import com.ifpe.ClinicaGeral.repository.Doctors;

@Service
public class RegisterDoctorService {

	@Autowired
	private Doctors doctors;	
	
	public void save(Doctor doctor) {
		doctors.save(doctor);
	}
}
