package com.api.aluguelcarro.service;

import java.util.List;

import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

	List<UserDTO> getUsers();

	User saveUser(User user);

	void updateUser(User user);
}
