package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.aluguelcarro.model.ItemVeiculo;
import com.api.aluguelcarro.model.Veiculo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veículos")
@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin
public class VeiculoController {

	
	@Operation(summary = "Busca veículo por ID", description = "Busca veículos por ID e retorna informações do veículo e de seus itens.")
	@GetMapping("{id}")
	public Veiculo getVeiculoById(@PathVariable("id") Long id){
		Veiculo v = new Veiculo();
		v.setAno("2020");
		v.setCambio("Manual");
		v.setCarroceria("Teste");
		v.setCidade("Belo Horizonte");
		v.setCombustivel("Flex");
		v.setDiaria(BigDecimal.valueOf(12134.32));
		v.setFinalPlaca("Q");
		v.setId(2l);
		v.setKm("20423km");
		v.setNome("Ford Fiesta");
		ItemVeiculo item = new ItemVeiculo();
		item.setId(1l);
		item.setDescricao("Ar condicionado");
		List<ItemVeiculo> items = new ArrayList<>();
		items.add(item);
		item = new ItemVeiculo();
		item.setId(2l);
		item.setDescricao("Vidros elétricos");
		items.add(item);
		v.setItemVeiculos(items);
		return v;
	}
	
	
	@Operation(summary = "Inserir veículo", description = "Salva um novo veículo e retorna 201 em caso de sucesso")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo saveVeiculo(@RequestBody Veiculo veiculo){
		return veiculo;
	}
	
	@Operation(summary = "Apagar veículo", description = "Apaga um veículo e retorna 204 em caso de sucesso")
	@DeleteMapping("")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteVeiculo(@RequestBody Veiculo veiculo){
		
	}
	
	@Operation(summary = "Atualizar veículo", description = "Atualiza um veículo e retorna 201 em caso de sucesso")
	@PutMapping("")
	public Veiculo updateVeiculo(@RequestBody Veiculo veiculo){
		return veiculo;
	}
	
}
