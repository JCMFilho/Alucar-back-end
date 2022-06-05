package com.api.aluguelcarro.service;

import java.util.List;

import com.api.aluguelcarro.model.UserDTO;

public interface UserService {

	List<UserDTO> getUsers();
}
