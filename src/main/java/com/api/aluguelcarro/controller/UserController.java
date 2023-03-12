package com.api.aluguelcarro.controller;

import java.util.List;

import com.api.aluguelcarro.exception.EmailSenderException;
import com.api.aluguelcarro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.api.aluguelcarro.service.MyUserDetailsService;
import com.api.aluguelcarro.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Controle de usuários")
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService IUserService;
	
	@Autowired
	private MyUserDetailsService service;

	@Operation(summary = "Busca Usuário", description = "Busca usuário pelo email.")
	@GetMapping("/{email}")
	public UserDetails searchUserByEmail(@PathVariable("email") String email) {
		return service.getByEmail(email);
	}

	@Operation(summary = "Cadastrar usuário", description = "Cadastrar novo usuário ao sistema")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody User usuario) {
		return IUserService.saveUser(usuario);
	}


	@Operation(summary = "Alterar senha")
	@PostMapping("/change-password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePassword(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		IUserService.changePassword(email,senha);
	}

	@Operation(summary = "Atualizar usuário", description = "Atualiza informações do usuário")
	@PutMapping("")
	public void updateUser(@RequestBody User user) {
		IUserService.updateUser(user);
	}

	@Operation(summary = "Recuperar senha", description = "Recuperar a senha do usuário do sistema")
	@PostMapping("/recover")
	public int recoverPassword(@RequestBody String email) throws EmailSenderException {
		return IUserService.recoverPassword(email);
	}

}
