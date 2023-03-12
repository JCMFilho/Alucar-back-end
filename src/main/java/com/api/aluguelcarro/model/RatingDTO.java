package com.api.aluguelcarro.model;

public class RatingDTO {

	private Integer id;
	private Integer usuarioId;
	private String usuario;
	private Integer veiculoId;
	private Integer nota;
	private String titulo;
	private String descricaoAvaliacao;

	public RatingDTO(){}

	public RatingDTO(Rating rating){
		this.id = rating.getId();
		this.nota = rating.getNota();
		this.titulo = rating.getTitulo();
		this.usuarioId = rating.getUsuario().getId();
		this.usuario = rating.getUsuario().getName();
		this.descricaoAvaliacao = rating.getDescricaoAvaliacao();
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricaoAvaliacao() {
		return descricaoAvaliacao;
	}

	public void setDescricaoAvaliacao(String descricaoAvaliacao) {
		this.descricaoAvaliacao = descricaoAvaliacao;
	}
}
