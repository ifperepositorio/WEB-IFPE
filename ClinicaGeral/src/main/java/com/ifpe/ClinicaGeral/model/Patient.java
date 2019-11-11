package com.ifpe.ClinicaGeral.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SuppressWarnings("serial")
public class Patient extends AbstractIds {

	@NotBlank(message = "Informe seu nome")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "Informe sua data de nascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dtBorn;
	
	@NotBlank(message = "Informe seu telefone")
	@Column(nullable = false)
	private String telephone;
}
