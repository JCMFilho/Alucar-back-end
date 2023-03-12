package com.api.aluguelcarro.controller;

import com.api.aluguelcarro.model.Endereco;
import com.api.aluguelcarro.service.IEnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Endereço")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    IEnderecoService service;

    @Operation(summary = "Busca Endereço por usuário", description = "Busca endereço do usuário pelo ID.")
    @GetMapping("/{id}")
    public Endereco searchEnderecoByUserId(@PathVariable("id") Integer id) {
        return service.getEnderecoByUser(id);
    }

    @Operation(summary = "Salva Endereço", description = "Salva o endereço do usuário.")
    @PostMapping
    public Endereco saveEndereco(@RequestBody Endereco endereco){
        return service.saveEndereco(endereco);
    }

}
