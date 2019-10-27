package com.ifpe.gacm.model;

public enum Especialidades {
	CARDIOLOGISTA("Cardiologista"),
	CLINICO("Clínico Geral"),
	PEDIATRA("Pediatra"),
	ANGIOLOGISTA("Angiologista"),
	ORTOPEDISTA("Ortopedista");
	
	private String descricao;
	
	 Especialidades(String descricao) {
		this.descricao = descricao;
	}
	 
	 public String getDescricao() {
		return descricao;
	}
	

}
