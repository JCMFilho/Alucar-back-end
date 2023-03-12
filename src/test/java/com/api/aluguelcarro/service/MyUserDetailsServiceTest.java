package com.api.aluguelcarro.service;

import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MyUserDetailsServiceTest {

    private MyUserDetailsService myUserDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        myUserDetailsService = new MyUserDetailsService(userRepository);
    }

    @Test
    void loadUserByUsername_whenUserExists_returnsUserDetails() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");
        user.setRoles(Collections.emptyList());

        when(userRepository.findByEmail("test@test.com")).thenReturn(user);

        assertEquals(user.getEmail(), myUserDetailsService.loadUserByUsername("test@test.com").getUsername());
        assertEquals(user.getPassword(), myUserDetailsService.loadUserByUsername("test@test.com").getPassword());
    }

    @Test
    void loadUserByUsername_whenUserDoesNotExist_throwsUsernameNotFoundException() {
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> myUserDetailsService.loadUserByUsername("test@test.com"));
    }

    @Test
    void getByEmail_whenUserExists_returnsUserDetails() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");
        user.setRoles(Collections.emptyList());

        when(userRepository.findByEmail("test@test.com")).thenReturn(user);

        assertEquals(user.getEmail(), myUserDetailsService.getByEmail("test@test.com").getUsername());
        assertEquals(user.getPassword(), myUserDetailsService.getByEmail("test@test.com").getPassword());
    }

    @Test
    void getByEmail_whenUserDoesNotExist_returnsUserRepositoryUserDetails() {
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        assertNotNull(myUserDetailsService.getByEmail("test@test.com"));
    }
}
