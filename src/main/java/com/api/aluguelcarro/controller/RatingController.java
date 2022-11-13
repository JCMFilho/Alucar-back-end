package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.aluguelcarro.model.RatingDTO;
import com.api.aluguelcarro.model.UserDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Avaliações")
@RestController
@RequestMapping("/api/avaliacao")
@CrossOrigin
public class RatingController {

	@Operation(summary = "Buscar avaliações por veículo", description = "Busca todas as availiações pelo ID do veículo.")
	@GetMapping("/{idVeiculo}")
	public List<RatingDTO> searchEvaluationsByVehicle(@PathVariable("idVeiculo") Integer idVeiculo) {
		RatingDTO evaluation = new RatingDTO();
		UserDTO u = new UserDTO();
		u.setEmail("queijo@queijo.com");
		u.setId(2);
		u.setNome("Joãozinho");
		u.setCidade("Belo Horizonte");
		u.setDataCadastro("19/05/2022");
		evaluation.setUsuario(u);
		evaluation.setDescricao("Muito bom mesmo, bagulho sensacional");
		evaluation.setNota(5);
		evaluation.setIdVeiculo(12);
		List<RatingDTO> evaluations = new ArrayList<>();
		evaluations.add(evaluation);

		return evaluations;
	}

	@Operation(summary = "Cadastrar avaliação", description = "Cadastrar nova avaliação para o veículo")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public RatingDTO saveEvaluation(@RequestBody RatingDTO avaliacao) {
		return avaliacao;
	}
}
