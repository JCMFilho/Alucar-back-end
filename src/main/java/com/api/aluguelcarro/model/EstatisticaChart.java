package com.api.aluguelcarro.model;

public class EstatisticaChart {

    private StatusAluguel status;
    private Long quantidade;

    public EstatisticaChart(Long quantidade, StatusAluguel status) {
        this.quantidade = quantidade;
        this.status = status;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }
}
