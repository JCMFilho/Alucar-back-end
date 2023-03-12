package com.api.aluguelcarro.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.api.aluguelcarro.exception.ValidationException;
import com.api.aluguelcarro.model.Rating;
import com.api.aluguelcarro.service.IRatingService;
import com.api.aluguelcarro.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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

	@Autowired
	private IRatingService service;

	@Operation(summary = "Cadastrar avaliação", description = "Cadastrar nova avaliação para o veículo")
	@PostMapping("")
	@Secured({Constants.ROLE_CLIENT})
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEvaluation(@RequestBody RatingDTO ratingDTO) throws ValidationException {
		service.saveRating(ratingDTO);
	}

	@Operation(summary = "Listar avaliações", description = "Listar todas as avaliações por veículo")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<RatingDTO> listarAvaliacoes(@PathVariable("id") Integer id) throws ValidationException {
		return service.listRatingsByVehicleId(id);
	}
}
