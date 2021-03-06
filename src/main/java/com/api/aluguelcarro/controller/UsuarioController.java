package com.api.aluguelcarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.aluguelcarro.model.UserDTO;
import com.api.aluguelcarro.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Controle de usuários")
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UserService userService;
	

	@Operation(summary = "Busca lista de usuários", description = "Busca a lista de usuários do sistema, ordenado pela data de criação.")
	@GetMapping("")
	public List<UserDTO> searchUser(@RequestParam(value = "cidade", required=false) String cidade, @Parameter(description = "Data inicial da pesquisa no formato dd/MM/YYYY")
	@RequestParam("dataInicio") String dataInicio, @Parameter(description = "Data final da pesquisa no formato dd/MM/YYYY")
	@RequestParam("dataFim") String dataFim){
		return userService.getUsers();
	}
	
	@Operation(summary = "Busca Usuário", description = "Busca usuário pelo ID.")
	@GetMapping("/{id}")
	public UserDTO searchUserById(@PathVariable("id") Integer id){
		return userService.getUsers().get(0);
	}
	
	
	@Operation(summary = "Cadastrar usuário", description = "Cadastrar novo usuário ao sistema")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO registerUser(@RequestBody UserDTO usuario) {
		return usuario;
	}
	
	@Operation(summary = "Fazer login")
	@GetMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public void login(@RequestParam("login") String login, @RequestParam("senha") String password) {	
	}
	
	@Operation(summary = "Atualizar usuário", description = "Atualiza informações do usuário")
	@PutMapping("")
	public UserDTO updateUser(@RequestBody UserDTO user) {
		return user;
	}
	
	
	
}
