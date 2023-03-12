package com.api.aluguelcarro.controller;

import com.api.aluguelcarro.model.Estatistica;
import com.api.aluguelcarro.service.IEstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Estatistica")
@RestController
@RequestMapping("/api/estatistica")
public class EstatisticaController {

    @Autowired
    IEstatisticaService service;

    @Operation(summary = "Busca estatísticas do sistema")
    @GetMapping
    public Estatistica buscarEstatisticas() {
        return service.buscarEstatisticas();
    }
}
