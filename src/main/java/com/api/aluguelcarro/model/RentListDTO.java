package com.api.aluguelcarro.model;

import com.api.aluguelcarro.utils.DateUtil;

import java.math.BigDecimal;

public class RentListDTO {

	private Integer id;
	private Integer meioPagamento;
	private String dataInicio;
	private String dataFim;
	private String status;

	private String nomeVeiculo;

	private String fabricanteVeiculo;

	private String nomeCliente;

	public RentListDTO(){

	}

	public RentListDTO(Rent rent){
		this.id = rent.getId();
		this.status = rent.getStatus().name();
		this.meioPagamento = rent.getMeioPagamento();
		this.dataInicio = DateUtil.timestampToString(rent.getDataInicio());
		this.dataFim = DateUtil.timestampToString(rent.getDataFim());
		this.nomeVeiculo = rent.getVeiculo().getNome();
		this.fabricanteVeiculo = rent.getVeiculo().getFabricante();
		this.nomeCliente = rent.getUsuario().getName();
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getFabricanteVeiculo() {
		return fabricanteVeiculo;
	}

	public void setFabricanteVeiculo(String fabricanteVeiculo) {
		this.fabricanteVeiculo = fabricanteVeiculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(Integer meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
