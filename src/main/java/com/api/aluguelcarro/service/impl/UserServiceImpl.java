package com.api.aluguelcarro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.aluguelcarro.model.UserDTO;
import com.api.aluguelcarro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<UserDTO> getUsers() {
		List<UserDTO> users = new ArrayList<>();
		UserDTO u = new UserDTO();
		u.setEmail("queijo@queijo.com");
		u.setId(2);
		u.setNome("Joãozinho");
		u.setCidade("Belo Horizonte");
		u.setDataCadastro("19/05/2022");
		users.add(u);
		u = new UserDTO();
		u.setEmail("teste@teste.com");
		u.setId(3);
		u.setNome("Joãozinho tavares");
		u.setCidade("Rio de Janeiro");
		u.setDataCadastro("19/04/2022");
		users.add(u);
		return users;
	}

}
