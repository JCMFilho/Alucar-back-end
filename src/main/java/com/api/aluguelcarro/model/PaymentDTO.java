package com.api.aluguelcarro.model;

public class PaymentDTO {

	private Integer id;
	private String meioPagamento;
	private String numeroCartao;
	private String validade;
	private String nomeProprietario;
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
