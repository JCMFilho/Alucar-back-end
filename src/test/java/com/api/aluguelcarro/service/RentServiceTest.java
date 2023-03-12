package com.api.aluguelcarro.service;

import com.api.aluguelcarro.model.Rent;
import com.api.aluguelcarro.model.RentDTO;
import com.api.aluguelcarro.model.RentListDTO;
import com.api.aluguelcarro.model.StatusAluguel;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.impl.RentService;
import com.api.aluguelcarro.utils.DateUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RentServiceTest {

    @Mock
    private RentRepository repository;

    @InjectMocks
    private RentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void cadastrarAluguelTest() throws ParseException {
        RentDTO rentDto = new RentDTO();
        rentDto.setIdUsuario(1);
        rentDto.setIdVeiculo(1);
        rentDto.setDataInicio("2023-02-01");
        rentDto.setDataFim("2023-02-07");
        rentDto.setMeioPagamento(1);
        rentDto.setValorTotal(BigDecimal.valueOf(100.00));

        service.cadastrarAluguel(rentDto);

        verify(repository, times(1)).save(any());
    }

    @Test
    void getRentsByUserIdTest() {
        when(repository.getRentById(anyInt()))
                .thenReturn(Collections.singletonList(new RentDTO()));

        List<RentDTO> rents = service.getRentsByUserId(1);

        assertEquals(1, rents.size());
    }

    @Test
    void atualizarEstadoAluguelTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Rent()));

        service.atualizarEstadoAluguel(1, StatusAluguel.CONCLUIDO);

        verify(repository, times(1)).save(any());
    }

    @Test
    void getRentListForManagementTest() throws ParseException {
        when(repository.getRentListForManagement(anyString(), any(), any()))
                .thenReturn(Collections.singletonList(new RentListDTO()));

        List<RentListDTO> rents = service.getRentListForManagement("2023-02-01", "2023-02-07", "John Doe");

        assertEquals(1, rents.size());
    }
}
