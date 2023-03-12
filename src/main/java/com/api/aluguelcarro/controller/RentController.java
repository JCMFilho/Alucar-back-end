package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.api.aluguelcarro.model.*;
import com.api.aluguelcarro.service.IRentService;
import com.api.aluguelcarro.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Aluguéis")
@RestController
@RequestMapping("/api/alugueis")
@CrossOrigin
public class RentController {

	@Autowired
	private IRentService service;

	@Operation(summary = "Buscar Aluguéis do usuário", description = "Busca todos os aluguéis do usuário.")
	@GetMapping("/{id}")
	@Secured({Constants.ROLE_CLIENT})
	public List<RentDTO> searchRentsByUserId(@PathVariable("id") Integer id) {
		return service.getRentsByUserId(id);
	}

	@Operation(summary = "Cadastra novo aluguel", description = "Cadastrar novo aluguel para o usuário informado")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Secured({Constants.ROLE_CLIENT})
	public void saveRent(@RequestBody RentDTO aluguel) throws ParseException {
		service.cadastrarAluguel(aluguel);
	}


	@Operation(summary = "Cancela aluguel")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Secured({Constants.ROLE_CLIENT,Constants.ROLE_ADMIN})
	public void cancelRent(@PathVariable("id") Integer id) {
		service.atualizarEstadoAluguel(id, StatusAluguel.CANCELADO);
	}

	@Operation(summary = "Concluí aluguel")
	@DeleteMapping("/concluir/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Secured({Constants.ROLE_ADMIN})
	public void concluirAluguel(@PathVariable("id") Integer id) {
		service.atualizarEstadoAluguel(id, StatusAluguel.CONCLUIDO);
	}

	@GetMapping("/filter")
	@Secured({Constants.ROLE_ADMIN})
	public List<RentListDTO> getRentListForManagement(@RequestParam(value = "dataInicial", required = false, defaultValue = "2000-01-01") String dataInicial,
													  @RequestParam(value = "dataFinal", required = false, defaultValue = "2999-12-31") String dataFinal,
													  @RequestParam(value = "nome", required = false, defaultValue = "") String nome) throws ParseException {
		return service.getRentListForManagement(dataInicial,dataFinal,nome);
	}
}
