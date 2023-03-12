package com.api.aluguelcarro.model;

import java.util.List;

public class Estatistica {
    private EstatisticaVeiculoDTO estatisticaVeiculo;

    private List<EstatisticaChart> chart;
    private Long totalAlugueis;

    public List<EstatisticaChart> getChart() {
        return chart;
    }

    public void setChart(List<EstatisticaChart> chart) {
        this.chart = chart;
    }

    public Long getTotalAlugueis() {
        return totalAlugueis;
    }

    public void setTotalAlugueis(Long totalAlugueis) {
        this.totalAlugueis = totalAlugueis;
    }

    public EstatisticaVeiculoDTO getEstatisticaVeiculo() {
        return estatisticaVeiculo;
    }

    public void setEstatisticaVeiculo(EstatisticaVeiculoDTO estatisticaVeiculo) {
        this.estatisticaVeiculo = estatisticaVeiculo;
    }
}
