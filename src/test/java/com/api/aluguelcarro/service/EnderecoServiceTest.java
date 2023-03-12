package com.api.aluguelcarro.service.impl;

import com.api.aluguelcarro.model.Endereco;
import com.api.aluguelcarro.model.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEnderecoByUser() {
        // mock do resultado de findByUsuarioId()
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Flores");
        when(enderecoRepository.findByUsuarioId(1)).thenReturn(endereco);

        // chama o método que estamos testando
        Endereco enderecoEncontrado = enderecoService.getEnderecoByUser(1);

        // verifica se o resultado mockado foi usado corretamente
        assertEquals(endereco, enderecoEncontrado);
    }

    @Test
    void saveEndereco() {
        // mock do resultado de save()
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Flores");
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        // chama o método que estamos testando
        Endereco enderecoSalvo = enderecoService.saveEndereco(endereco);

        // verifica se o resultado mockado foi usado corretamente
        assertEquals(endereco, enderecoSalvo);
    }
}
