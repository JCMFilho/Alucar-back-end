package com.api.aluguelcarro.model;

import com.api.aluguelcarro.utils.DateUtil;

import java.math.BigDecimal;

public class RentDTO {

	private Integer id;
	private Integer idUsuario;
	private Integer idVeiculo;
	private Integer meioPagamento;
	private String dataAluguel;
	private String dataInicio;
	private String dataFim;
	private String status;
	private BigDecimal valorTotal;

	private String imagemVeiculo;

	private String nomeVeiculo;

	private String fabricanteVeiculo;

	public RentDTO(){

	}

	public RentDTO(Rent rent){
		this.id = rent.getId();
		this.status = rent.getStatus().name();
		this.valorTotal = rent.getValorTotal();
		this.meioPagamento = rent.getMeioPagamento();
		this.dataAluguel = DateUtil.timestampToString(rent.getDataAluguel());
		this.dataInicio = DateUtil.timestampToString(rent.getDataInicio());
		this.dataFim = DateUtil.timestampToString(rent.getDataFim());
		this.imagemVeiculo = rent.getVeiculo().getImagem();
		this.nomeVeiculo = rent.getVeiculo().getNome();
		this.fabricanteVeiculo = rent.getVeiculo().getFabricante();
	}

	public void setImagemVeiculo(String imagemVeiculo) {
		this.imagemVeiculo = imagemVeiculo;
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

	public String getImagemVeiculo(){
		return this.imagemVeiculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public Integer getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(Integer meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
