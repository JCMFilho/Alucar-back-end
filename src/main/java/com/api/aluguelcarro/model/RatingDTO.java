package com.api.aluguelcarro.model;

public class RatingDTO {

	private UserDTO usuario;
	private Integer idVeiculo;
	private int nota;
	private String descricao;

	public UserDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UserDTO usuario) {
		this.usuario = usuario;
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
