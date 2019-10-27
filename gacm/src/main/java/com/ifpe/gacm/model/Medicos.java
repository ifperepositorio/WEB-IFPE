package com.ifpe.gacm.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "medicos")
@SuppressWarnings("serial")
@Getter
@Setter
public class Medicos extends AbstractIds {
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String crm;
	
	@Enumerated(EnumType.STRING)
	private Especialidades especialidade;
	
	
}
