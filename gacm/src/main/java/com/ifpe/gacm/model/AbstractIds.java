package com.ifpe.gacm.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@SuppressWarnings("serial")
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractIds implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
