package com.ifpe.ClinicaGeral.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@SuppressWarnings("serial")
@Getter
@Setter
public class Hours extends AbstractIds {

	
	@Column(unique = true, nullable = false)
	private LocalTime horaMinuto;
	
	 @OneToMany(mappedBy = "hour")
	 private List<Doctor> doctor;
	
	
}
