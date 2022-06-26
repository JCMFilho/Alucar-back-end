package com.api.aluguelcarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALUGUEL")
public class Aluguel {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")
	 private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
