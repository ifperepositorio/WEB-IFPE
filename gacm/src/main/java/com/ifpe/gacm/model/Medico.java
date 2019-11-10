package com.ifpe.gacm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicos")
@SuppressWarnings("serial")
@Getter
@Setter
public class Medico extends AbstractIds {
	
	@NotNull(message = "Nome é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotNull(message = "crm é obrigatório")
	@Column(nullable = false)
	private String crm;	
	
	private String especialidade;
	
	
}
