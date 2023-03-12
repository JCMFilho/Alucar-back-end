package com.api.aluguelcarro.service;

import com.api.aluguelcarro.exception.ValidationException;
import com.api.aluguelcarro.model.*;
import com.api.aluguelcarro.model.repository.RatingRepository;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.impl.RatingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class RatingServiceTest {

    @Mock
    RatingRepository ratingRepository;

    @Mock
    RentRepository rentRepository;

    @InjectMocks
    RatingService ratingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveRating() throws ValidationException {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setUsuarioId(1);
        ratingDTO.setVeiculoId(1);
        ratingDTO.setNota(4);
        ratingDTO.setTitulo("Ótimo carro");
        ratingDTO.setDescricaoAvaliacao("Este carro é muito confortável e econômico.");

        when(rentRepository.getRentByUserAndVehicleId(1, 1)).thenReturn(new ArrayList<>());
        Assertions.assertThrows(ValidationException.class, () -> ratingService.saveRating(ratingDTO));

        Rating rent = new Rating();
        when(ratingRepository.findByUsuarioIdAndVeiculoId(1, 1)).thenReturn(rent);
        Assertions.assertThrows(ValidationException.class, () -> ratingService.saveRating(ratingDTO));

        when(rentRepository.getRentByUserAndVehicleId(1, 1)).thenReturn(List.of(new Rent()));
        when(ratingRepository.findByUsuarioIdAndVeiculoId(1, 1)).thenReturn(null);

        ratingService.saveRating(ratingDTO);
    }

    @Test
    public void testListRatingsByVehicleId() {
        when(ratingRepository.findByVeiculoId(1)).thenReturn(new ArrayList<>());
        List<RatingDTO> ratingDTOS = ratingService.listRatingsByVehicleId(1);
        Assertions.assertNotNull(ratingDTOS);
    }
}
