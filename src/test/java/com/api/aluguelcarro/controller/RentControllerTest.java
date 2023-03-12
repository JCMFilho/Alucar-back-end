package com.api.aluguelcarro.controller;

import com.api.aluguelcarro.model.RentDTO;
import com.api.aluguelcarro.model.RentListDTO;
import com.api.aluguelcarro.model.StatusAluguel;
import com.api.aluguelcarro.service.IRentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RentControllerTest {

    @Mock
    private IRentService service;

    @InjectMocks
    private RentController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchRentsByUserId() throws ParseException {
        List<RentDTO> rents = new ArrayList<>();
        RentDTO rentDTO = new RentDTO();
        rentDTO.setId(1);
        rents.add(rentDTO);
        when(service.getRentsByUserId(1)).thenReturn(rents);

        List<RentDTO> result = controller.searchRentsByUserId(1);

        assertEquals(rents, result);

        verify(service, times(1)).getRentsByUserId(1);
    }

    @Test
    public void testSaveRent() throws ParseException {
        controller.saveRent(new RentDTO());

        verify(service, times(1)).cadastrarAluguel(any(RentDTO.class));
    }

    @Test
    public void testCancelRent() {

        controller.cancelRent(1);

        verify(service, times(1)).atualizarEstadoAluguel(1, StatusAluguel.CANCELADO);
    }

    @Test
    public void testConcluirAluguel() {
        controller.concluirAluguel(1);

        verify(service, times(1)).atualizarEstadoAluguel(1, StatusAluguel.CONCLUIDO);
    }

    @Test
    public void testGetRentListForManagement() throws ParseException {
        List<RentListDTO> rents = new ArrayList<>();
        controller.getRentListForManagement("","","");

        verify(service, times(1)).getRentListForManagement("","","");
    }
}