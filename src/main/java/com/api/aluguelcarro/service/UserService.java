package com.api.aluguelcarro.service;

import java.util.List;

import com.api.aluguelcarro.exception.EmailSenderException;
import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.UserDTO;

public interface UserService {

	List<UserDTO> getUsers();

	User saveUser(User user);

	void updateUser(User user);

	int recoverPassword(String email) throws EmailSenderException;

	void changePassword(String email, String password);
}
