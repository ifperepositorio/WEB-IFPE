package com.ifpe.ClinicaGeral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.ClinicaGeral.model.Doctor;

public interface Doctors extends JpaRepository<Doctor, Long> {

}
