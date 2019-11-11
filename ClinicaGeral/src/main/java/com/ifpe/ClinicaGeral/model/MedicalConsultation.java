package com.ifpe.ClinicaGeral.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
@Getter
@Setter
public class MedicalConsultation extends AbstractIds {

	
	@NotBlank(message =  "Informe o telefone")
	@Column(nullable = false)
	private String telephone;
	
	@NotNull(message = "Informe o médico")
	@ManyToOne
	@JoinColumn(name="id_doctor")
	private Doctor doctor;
	
	@NotNull(message = "Informe o paciente")
	@ManyToOne
	@JoinColumn(name="id_patient")
	private Patient patient;	
	
	@NotNull(message = "Informe o horario")
	@ManyToOne
	@JoinColumn(name="id_hour")
	private Hours hour;
	
	@NotNull(message = "Informe sua data de nascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateConsulation;
}
