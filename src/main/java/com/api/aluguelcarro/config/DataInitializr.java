package com.api.aluguelcarro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.api.aluguelcarro.model.Role;
import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.repository.RoleRepository;
import com.api.aluguelcarro.model.repository.UserRepository;
import com.api.aluguelcarro.utils.Constants;

import java.util.Arrays;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {


	@Bean 
	public PasswordEncoder encoder() { 
	    return new BCryptPasswordEncoder(); 
	} 
	
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        Iterable<User> users = userRepository.findAll();

        if (!users.iterator().hasNext()) {
            createUser("Administrador do sistema", "admin@admin.com", passwordEncoder.encode("123456"), Constants.ROLE_ADMIN, "09999999998");
            createUser("João César", "clienteteste@teste.com", passwordEncoder.encode("123456"), Constants.ROLE_CLIENT, "09999999999");
        }
    }

    public void createUser(String name, String email, String password, String roleName, String cpf) {

        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role),cpf);
        userRepository.save(user);
    }

}