package com.api.aluguelcarro.model;

public class EstatisticaVeiculoDTO {

    private Long quantidade;

    private String nome;

    private String fabricante;

    public EstatisticaVeiculoDTO(Long quantidade, String nome, String fabricante) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public EstatisticaVeiculoDTO(){

    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
