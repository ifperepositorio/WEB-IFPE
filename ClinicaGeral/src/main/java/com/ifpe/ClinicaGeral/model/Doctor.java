package com.ifpe.ClinicaGeral.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SuppressWarnings("serial")
public class Doctor extends AbstractIds {
	
	@Column(nullable = false)	
	@Size(min = 10, max = 100, message = "o nome deve conter no mínimo 10 caracteres")
	@NotBlank(message =  "Nome é ogbrigatório")
	private String name;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message =  "O crm é obrigatório")
	private String crm;	
	
	@NotNull(message = "informe uma especialidade")
	@ManyToOne
	@JoinColumn(name = "codigo_especialty")
	private Especialty especialty;
	
	@NotNull(message = "informe um horário")
	@ManyToOne
	@JoinColumn(name = "codigo_hours")
	private Hours hour;
	
	@OneToMany(mappedBy = "doctor")
	private List<MedicalConsultation> agendamentos;
	
	

}
