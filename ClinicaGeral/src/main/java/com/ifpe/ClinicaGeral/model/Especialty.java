package com.ifpe.ClinicaGeral.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
@Getter
@Setter
public class Especialty extends AbstractIds {
	
	@NotBlank(message = "informe uma especialidade")
	private String name;
	
    @OneToMany(mappedBy = "especialty")
	private List<Doctor> doctor;
}
