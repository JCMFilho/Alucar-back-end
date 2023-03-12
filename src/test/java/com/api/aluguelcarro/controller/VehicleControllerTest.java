package com.api.aluguelcarro.controller;

import com.api.aluguelcarro.model.Vehicle;
import com.api.aluguelcarro.service.IVehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

    @InjectMocks
    VehicleController controler;

    @Mock
    IVehicleService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteVehicle() {
        controler.deleteVeiculo(1);

        verify(service, times(1)).deleteVehicle(1);
    }

    @Test
    void testGetVeiculoById() {
        controler.getVeiculoById(1);

        verify(service, times(1)).getVehicle(1);
    }

    @Test
    void testSaveVeiculo() {
        var vehicle = new Vehicle();
        controler.saveVeiculo(vehicle);

        verify(service, times(1)).saveVehicle(vehicle);
    }

    @Test
    void testGetVehicleHomePage() {
        controler.getVehicleHomePage();

        verify(service, times(1)).getVehicleHomePage();
    }

    @Test
    void testGetVehiclesByFilters() {

        controler.getVehiclesByFilters("","","");

        verify(service, times(1)).getVehicles("","","");
    }
}
