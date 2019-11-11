package com.ifpe.ClinicaGeral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.ClinicaGeral.model.Hours;

public interface Hour extends JpaRepository<Hours, Long>{

}
