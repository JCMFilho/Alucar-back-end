package com.api.aluguelcarro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Meios de pagamento")
@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class MeioPagamentoController {

}
