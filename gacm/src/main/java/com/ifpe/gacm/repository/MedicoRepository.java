package com.ifpe.gacm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.gacm.model.Medicos;

public interface MedicoRepository extends JpaRepository<Medicos, Long> {

}
