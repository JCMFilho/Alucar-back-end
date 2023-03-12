package com.api.aluguelcarro.service;

import com.api.aluguelcarro.exception.EmailSenderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordRecoveryServiceTest {

    @Mock
    private JavaMailSenderImpl mailSender;

    @InjectMocks
    private PasswordRecoveryService passwordRecoveryService;
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSendPasswordRecoveryEmail() throws EmailSenderException {
        String toEmail = "test@example.com";
        String subject = "Test email";
        String messageBody = "Test message";

        ReflectionTestUtils.setField(passwordRecoveryService, "fromEmail", "from@example.com");
        ReflectionTestUtils.setField(passwordRecoveryService, "fromSenha", "password");

        assertThrows(EmailSenderException.class, () -> {
            passwordRecoveryService.sendPasswordRecoveryEmail(toEmail, subject, messageBody);
        });


    }


}
