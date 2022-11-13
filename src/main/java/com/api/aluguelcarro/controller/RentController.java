package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.api.aluguelcarro.model.RentDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Aluguéis")
@RestController
@RequestMapping("/api/alugueis")
@CrossOrigin
public class RentController {

	@Operation(summary = "Buscar Aluguéis do usuário", description = "Busca todos os aluguéis do usuário.")
	@GetMapping("/{id}")
	public List<RentDTO> searchRentsByUserId(@PathVariable("id") Integer id) {
		RentDTO aluguel = new RentDTO();
		aluguel.setDataAluguel("19/06/2022");
		aluguel.setDataInicio("21/06/2022");
		aluguel.setDataFim("23/06/2022");
		aluguel.setStatus("CONCLUÍDO");
		aluguel.setValorTotal(BigDecimal.valueOf(179.12));
		aluguel.setId(1);
		aluguel.setIdUsuario(23);
		List<RentDTO> alugueis = new ArrayList<>();
		alugueis.add(aluguel);
		return alugueis;
	}

	@Operation(summary = "Cadastra novo aluguel", description = "Cadastrar novo aluguel para o usuário informado")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public RentDTO saveRent(@RequestBody RentDTO aluguel) {
		return aluguel;
	}

	@Operation(summary = "Atualiza aluguel")
	@PutMapping("")
	public RentDTO updateRent(@RequestBody RentDTO aluguel) {
		return aluguel;
	}

	@Operation(summary = "Cancela aluguel")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void CancelRent(@PathVariable("id") Integer id) {
	}

}
