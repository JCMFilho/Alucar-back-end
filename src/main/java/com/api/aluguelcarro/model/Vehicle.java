package com.api.aluguelcarro.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	@Basic
	private Integer id;

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

	@Column(name = "FABRICANTE", length = 45)
	private String fabricante;

	@Column(name = "DATA", length = 45)
	private String data;

	@Column(name = "CARROCERIA", length = 45)
	private String carroceria;

	@Column(name = "COMBUSTIVEL", length = 20)
	private String combustivel;

	@Column(name = "FINAL_PLACA", length = 1)
	private String finalPlaca;

	@Column(name = "VALOR_DIARIA")
	private BigDecimal diaria;

	@Column(name = "IMAGEM")
	private String imagem;

	@Column(name = "COR")
	private String cor;

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@OneToMany(mappedBy = "vehicle")
	private Set<VehicleItem> itemVeiculos;

	public Vehicle(){

	}
	public Vehicle(Integer id, String nome, String cidade, String ano, String km, String cambio, String fabricante, String data, String carroceria, String combustivel, String finalPlaca, BigDecimal diaria, String imagem, String cor) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.ano = ano;
		this.km = km;
		this.cambio = cambio;
		this.fabricante = fabricante;
		this.data = data;
		this.carroceria = carroceria;
		this.combustivel = combustivel;
		this.finalPlaca = finalPlaca;
		this.diaria = diaria;
		this.imagem = imagem;
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Set<VehicleItem> getItemVeiculos() {
		return itemVeiculos;
	}

	public void setItemVeiculos(Set<VehicleItem> itemVeiculos) {
		this.itemVeiculos = itemVeiculos;
	}

}
