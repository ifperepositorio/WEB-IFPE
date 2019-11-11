package com.ifpe.ClinicaGeral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.ClinicaGeral.model.MedicalConsultation;

public interface MedicalConsulations extends JpaRepository<MedicalConsultation, Long> {

}
