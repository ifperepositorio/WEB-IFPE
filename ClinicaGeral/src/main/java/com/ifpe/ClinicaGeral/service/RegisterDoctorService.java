package com.ifpe.ClinicaGeral.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.ClinicaGeral.model.Doctor;
import com.ifpe.ClinicaGeral.repository.Doctors;
import com.ifpe.ClinicaGeral.service.exception.CrmIsRegisterException;

@Service
public class RegisterDoctorService {

	@Autowired
	private Doctors doctors;	
	
	public void save(Doctor doctor) {
		Optional<Doctor> doctorOptional = doctors.findByCrm(doctor.getCrm());
		if(doctorOptional.isPresent()) {
			throw new CrmIsRegisterException("CRM já cadastrado");
		}
		doctors.save(doctor);
	}
}
