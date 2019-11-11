package com.ifpe.ClinicaGeral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.ClinicaGeral.model.Patient;

public interface Patients extends JpaRepository<Patient, Long> {

}
