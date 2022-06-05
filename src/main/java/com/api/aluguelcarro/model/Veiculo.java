package com.api.aluguelcarro.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "NOME", length = 255)
	 private String nome;
	 
	 @Column(name = "CIDADE", length = 45)
	 private String cidade;

	 @Column(name = "ANO", length = 4)
	 private String ano;
	 
	 @Column(name = "KM", length = 45)
	 private String km;
	 
	 @Column(name = "CAMBIO", length = 45)
	 private String cambio;
	 
	 @Column(name = "CARROCERIA", length = 45)
	 private String carroceria;
	 
	 @Column(name = "COMBUSTIVEL", length = 20)
	 private String combustivel;
	 
	 @Column(name = "FINAL_PLACA", length = 1)
	 private String finalPlaca;
	 
	 @Column(name = "VALOR_DIARIA")
	 private BigDecimal diaria;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
	 private List<ItemVeiculo> itemVeiculos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getFinalPlaca() {
		return finalPlaca;
	}

	public void setFinalPlaca(String finalPlaca) {
		this.finalPlaca = finalPlaca;
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public List<ItemVeiculo> getItemVeiculos() {
		return itemVeiculos;
	}

	public void setItemVeiculos(List<ItemVeiculo> itemVeiculos) {
		this.itemVeiculos = itemVeiculos;
	}
	 
	 
}
