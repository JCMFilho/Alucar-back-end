package com.api.aluguelcarro.model;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

public class VehicleDTO {

    private Integer id;
    private String nome;
    private String cidade;
    private String ano;
    private String km;
    private String cambio;
    private String fabricante;
    private String data;
    private String carroceria;
    private String combustivel;
    private String finalPlaca;
    private BigDecimal diaria;
    private String imagem;
    private String cor;
    private Set<VehicleItem> itemVeiculos;

    private Set<RatingDTO> ratings;



    public VehicleDTO(Vehicle vehicle){
        this.id = vehicle.getId();
        this.ano = vehicle.getAno();
        this.nome = vehicle.getNome();
        this.km = vehicle.getKm();
        this.cor = vehicle.getCor();
        this.cidade = vehicle.getCidade();
        this.fabricante = vehicle.getFabricante();
        this.imagem = vehicle.getImagem();
        this.cambio = vehicle.getCambio();
        this.carroceria = vehicle.getCarroceria();
        this.combustivel = vehicle.getCombustivel();
        this.data = vehicle.getData();
        this.diaria = vehicle.getDiaria();
        this.finalPlaca = vehicle.getFinalPlaca();
        this.itemVeiculos = vehicle.getItemVeiculos().stream().map(item -> {
            VehicleItem vehicleItem = new VehicleItem();
            vehicleItem.setId(item.getId());
            vehicleItem.setDescricao(item.getDescricao());
            return vehicleItem;
        }).collect(Collectors.toSet());
        this.ratings = vehicle.getRatings().stream().map(item -> {
            RatingDTO rating = new RatingDTO();
            rating.setDescricaoAvaliacao(item.getDescricaoAvaliacao());
            rating.setNota(item.getNota());
            rating.setTitulo(item.getTitulo());
            rating.setUsuario(item.getUsuario().getName());
            return rating;
        }).collect(Collectors.toSet());
    }

    public Set<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(Set<RatingDTO> ratings) {
        this.ratings = ratings;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Set<VehicleItem> getItemVeiculos() {
        return itemVeiculos;
    }

    public void setItemVeiculos(Set<VehicleItem> itemVeiculos) {
        this.itemVeiculos = itemVeiculos;
    }
}
