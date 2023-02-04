package com.api.aluguelcarro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.api.aluguelcarro.exception.EmailSenderException;
import com.api.aluguelcarro.model.Role;
import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.repository.RoleRepository;
import com.api.aluguelcarro.model.repository.UserRepository;
import com.api.aluguelcarro.service.PasswordRecoveryService;
import com.api.aluguelcarro.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.aluguelcarro.model.UserDTO;
import com.api.aluguelcarro.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PasswordRecoveryService emailService;

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

	@Override
	public User saveUser(User user) {
		Role role = new Role(Constants.ROLE_CLIENT);
		this.roleRepository.save(role);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(List.of(role));
		return repository.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		repository.updateUser(user.getId(),user.getPhone(),user.getCpf(),user.getName());
	}

	@Override
	public int recoverPassword(String email) throws EmailSenderException {
		validateByEmail(email);
		Random codeGenerator = new Random();
		int code = codeGenerator.nextInt(1000000);
		String messageBody = "O seu código para recuperar a senha é: " + code;
		emailService.sendPasswordRecoveryEmail(email,"Recuperação de senha", messageBody);
		return code;
	}

	@Override
	public void changePassword(String email, String password) {
		User usuario = repository.findByEmail(email);
		usuario.setPassword(passwordEncoder.encode(password));
		repository.save(usuario);
	}

	private void validateByEmail(String email) throws EmailSenderException {
		if(StringUtils.isEmpty(email) || this.repository.findByEmail(email) == null){
			throw new EmailSenderException("E-mail inválido ou não cadastrado");
		}
	}

}
