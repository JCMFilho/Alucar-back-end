package com.api.aluguelcarro.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.api.aluguelcarro.model.*;
import com.api.aluguelcarro.service.impl.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.aluguelcarro.model.repository.VehicleItemRepository;
import com.api.aluguelcarro.model.repository.VehicleRepository;
public class VehicleServiceTest {

    @Mock
    private VehicleRepository repository;

    @Mock
    private VehicleItemRepository itemRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnListOfVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, "Uno", "São Paulo", "2020", "0", "Manual", "Fiat", "10/03/2023", "Hatch", "Flex", "0", BigDecimal.valueOf(50.0), "image", "Branco"));
        vehicles.add(new Vehicle(2, "Celta", "Rio de Janeiro", "2018", "50000", "Automático", "Chevrolet", "10/03/2023", "Hatch", "Flex", "0", BigDecimal.valueOf(70.0), "image", "Preto"));
        vehicles.add(new Vehicle(3, "Corsa", "São Paulo", "2015", "100000", "Manual", "Chevrolet", "10/03/2023", "Sedan", "Gasolina", "1", BigDecimal.valueOf(100.0), "image", "Azul"));
        Set<VehicleItem> items = new HashSet<>();
        var item = new VehicleItem();
        item.setDescricao("Teste");
        item.setId(123);
        items.add(item);
        vehicles.get(0).setItemVeiculos(items);
        String nome = "Celta";
        String cidade = "Rio de Janeiro";
        String fabricante = "Chevrolet";
        var rating = new Rating();
        rating.setDescricaoAvaliacao("Teste");
        rating.setUsuario(new User());
        Set<Rating> ratings = new HashSet<>();
        ratings.add(rating);
        vehicles.get(0).setRatings(ratings);
        when(repository.getVehiclesByFilter(nome, cidade, fabricante)).thenReturn(vehicles);

        List<VehicleDTO> result = vehicleService.getVehicles(nome, cidade, fabricante);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(1).getNome()).isEqualTo("Celta");
        assertThat(result.get(1).getCidade()).isEqualTo("Rio de Janeiro");
        assertThat(result.get(1).getFabricante()).isEqualTo("Chevrolet");
    }

    @Test
    public void shouldSaveVehicle() {
        Vehicle vehicleToSave = new Vehicle(1, "Uno", "São Paulo", "2020", "0", "Manual", "Fiat", "10/03/2023", "Hatch", "Flex", "0", BigDecimal.valueOf(50.0), "image", "Branco");

        when(repository.save(any(Vehicle.class))).thenReturn(vehicleToSave);

        Vehicle result = vehicleService.saveVehicle(vehicleToSave);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
    }
}
