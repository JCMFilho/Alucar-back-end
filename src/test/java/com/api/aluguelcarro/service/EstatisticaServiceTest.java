package com.api.aluguelcarro.service;

import com.api.aluguelcarro.model.*;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.impl.EstatisticaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EstatisticaServiceTest {

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private EstatisticaService estatisticaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarEstatisticas() {
        // mock do resultado de getTopRentVehicle()
        EstatisticaVeiculoDTO veiculoMaisAlugado = new EstatisticaVeiculoDTO();
        veiculoMaisAlugado.setFabricante("Ford");
        veiculoMaisAlugado.setNome("Fiesta");
        veiculoMaisAlugado.setQuantidade(230L);
        when(rentRepository.getTopRentVehicle()).thenReturn(List.of(veiculoMaisAlugado));

        // mock do resultado de count()
        long totalAlugueis = 42L;
        when(rentRepository.count()).thenReturn(totalAlugueis);

        // mock do resultado de getRentDashboard()
        var chart = new EstatisticaChart(230L, StatusAluguel.CONCLUIDO);
        when(rentRepository.getRentDashboard()).thenReturn(List.of(chart));

        // chama o método que estamos testando
        Estatistica estatistica = estatisticaService.buscarEstatisticas();

        // verifica se os resultados mockados foram usados corretamente
        assertEquals(veiculoMaisAlugado, estatistica.getEstatisticaVeiculo());
        assertEquals(totalAlugueis, estatistica.getTotalAlugueis());
        assertEquals(chart, estatistica.getChart().get(0));
    }
}
