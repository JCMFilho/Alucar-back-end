package com.api.aluguelcarro.service;

import com.api.aluguelcarro.exception.ValidationException;
import com.api.aluguelcarro.model.RatingDTO;

import java.util.List;

public interface IRatingService {

    void saveRating(RatingDTO ratingDTO) throws ValidationException;

    List<RatingDTO> listRatingsByVehicleId(Integer id);
}
