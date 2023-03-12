package com.api.aluguelcarro.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "AVALIACAO")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USUARIO", nullable = false)
    @JsonIgnore
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "VEICULO", nullable = false)
    private Vehicle veiculo;

    @Column(name = "NOTA")
    private Integer nota;

    @Column(name="TITULO")
    private String titulo;

    @Column(name="DESCRICAO_AVALIACAO")
    private String descricaoAvaliacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Vehicle getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Vehicle veiculo) {
        this.veiculo = veiculo;
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
