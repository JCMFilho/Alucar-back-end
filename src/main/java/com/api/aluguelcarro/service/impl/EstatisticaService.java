package com.api.aluguelcarro.service.impl;

import com.api.aluguelcarro.model.Estatistica;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.IEstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService implements IEstatisticaService {

    @Autowired
    RentRepository rentRepository;

    @Override
    public Estatistica buscarEstatisticas() {
        var estatistica = new Estatistica();
        estatistica.setEstatisticaVeiculo(rentRepository.getTopRentVehicle().get(0));
        estatistica.setTotalAlugueis(rentRepository.count());
        estatistica.setChart(rentRepository.getRentDashboard());
        return estatistica;
    }
}
