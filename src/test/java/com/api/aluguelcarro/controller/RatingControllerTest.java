package com.api.aluguelcarro.controller;

import com.api.aluguelcarro.exception.ValidationException;
import com.api.aluguelcarro.model.RatingDTO;
import com.api.aluguelcarro.service.IRatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RatingControllerTest {

    @InjectMocks
    RatingController ratingController;

    @Mock
    IRatingService ratingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEvaluation() throws ValidationException {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setTitulo("Comentário");
        ratingDTO.setNota(4);
        ratingDTO.setDescricaoAvaliacao("Testetete");
        ratingController.saveEvaluation(ratingDTO);
    }

    @Test
    void testListarAvaliacoes() throws ValidationException {
        List<RatingDTO> expected = new ArrayList<>();
        expected.add(new RatingDTO());
        expected.add(new RatingDTO());
        when(ratingService.listRatingsByVehicleId(1)).thenReturn(expected);
        List<RatingDTO> result = ratingController.listarAvaliacoes(1);
        assertEquals(expected, result);
    }
}
