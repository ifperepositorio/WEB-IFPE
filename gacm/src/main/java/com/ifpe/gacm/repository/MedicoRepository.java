package com.ifpe.gacm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.gacm.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
