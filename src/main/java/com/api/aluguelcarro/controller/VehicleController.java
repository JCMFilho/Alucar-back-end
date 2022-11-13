package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.api.aluguelcarro.model.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.api.aluguelcarro.model.VehicleItem;
import com.api.aluguelcarro.service.impl.VehicleService;
import com.api.aluguelcarro.utils.Constants;
import com.api.aluguelcarro.model.Vehicle;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veículos")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @Operation(summary = "Busca veículo por ID", description = "Busca veículos por ID e retorna informações do veículo e de seus itens.")
    @GetMapping("/{id}")
    public VehicleDTO getVeiculoById(@PathVariable("id") Integer id) {
        return service.getVehicle(id);
    }

    @Operation(summary = "Inserir veículo", description = "Salva um novo veículo e retorna 201 em caso de sucesso")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle saveVeiculo(@RequestBody Vehicle veiculo) {
        return service.saveVehicle(veiculo);
    }

    @Operation(summary = "Apagar veículo", description = "Apaga um veículo e retorna 204 em caso de sucesso")
    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable("id") Integer id) {
        service.deleteVehicle(id);
    }

    @GetMapping
    public List<VehicleDTO> getVehicleHomePage() {
        return service.getVehicleHomePage();
    }

    @GetMapping("/filter")
    public List<VehicleDTO> getVehiclesByFilters(@RequestParam(value = "cidade", required = false, defaultValue = "") String cidade, @RequestParam(value = "fabricante", required = false, defaultValue = "") String fabricante, @RequestParam(value = "nome", required = false, defaultValue = "") String nome) {
        return service.getVehicles(nome,cidade,fabricante);
    }


}
