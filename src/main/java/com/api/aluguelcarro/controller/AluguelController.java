package com.api.aluguelcarro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Aluguéis")
@RestController
@RequestMapping("/api/alugueis")
@CrossOrigin
public class AluguelController {

}
