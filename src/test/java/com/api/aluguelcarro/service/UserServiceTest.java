package com.api.aluguelcarro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.api.aluguelcarro.exception.EmailSenderException;
import com.api.aluguelcarro.model.Role;
import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.UserDTO;
import com.api.aluguelcarro.model.repository.RoleRepository;
import com.api.aluguelcarro.model.repository.UserRepository;
import com.api.aluguelcarro.service.PasswordRecoveryService;
import com.api.aluguelcarro.service.impl.UserService;
import com.api.aluguelcarro.utils.Constants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;

@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    PasswordRecoveryService emailService;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUserTest() {
        User user = new User("Teste", "teste@teste.com", "123456");
        service.saveUser(user);
        assertEquals(1, user.getRoles().size());
    }

    @Test
    void updateUserTest() {
        User user = new User("Teste", "teste@teste.com", "123456");
        user.setId(1);
        service.updateUser(user);
    }

    @Test
    void recoverPasswordTest() throws EmailSenderException {
        User user = new User("Teste", "teste@teste.com", "123456");
        List<User> users = new ArrayList<>();
        users.add(user);
        String email = "teste@teste.com";
        int code = 123456;

        when(repository.findByEmail(anyString())).thenReturn(new User());
        service.recoverPassword(email);
        assertEquals(code, 123456);
    }

    @Test
    void recoverPasswordInvalidEmailTest() {
        String email = "";
        assertThrows(EmailSenderException.class, () -> service.recoverPassword(email));
    }

    @Test
    void changePasswordTest() {
        User user = new User("Teste", "teste@teste.com", "123456");
        String newPassword = "abcdef";
        when(repository.findByEmail(anyString())).thenReturn(new User());
        when(passwordEncoder.encode(anyString())).thenReturn("Teste");
        service.changePassword(user.getEmail(), newPassword);
        assertThat(user.getPassword()).isNotEqualTo(newPassword);
    }

}
