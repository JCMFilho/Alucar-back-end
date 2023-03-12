package com.api.aluguelcarro.service.impl;

import com.api.aluguelcarro.exception.ValidationException;
import com.api.aluguelcarro.model.Rating;
import com.api.aluguelcarro.model.RatingDTO;
import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.Vehicle;
import com.api.aluguelcarro.model.repository.RatingRepository;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements IRatingService {

    @Autowired
    RatingRepository repository;

    @Autowired
    RentRepository rentRepository;

    @Override
    public void saveRating(RatingDTO ratingDTO) throws ValidationException {
        var rent = rentRepository.getRentByUserAndVehicleId(ratingDTO.getUsuarioId(), ratingDTO.getVeiculoId());
        if(rent == null || rent.size() == 0){
            throw new ValidationException("Você precisa alugar este veículo para poder cadastrar uma avaliação.");
        }
        if(repository.findByUsuarioIdAndVeiculoId(ratingDTO.getUsuarioId(), ratingDTO.getVeiculoId()) != null){
            throw new ValidationException("Você já possuí uma avaliação cadastrada para esse veículo");
        }
        Rating rating = new Rating();
        rating.setNota(ratingDTO.getNota());
        rating.setTitulo(ratingDTO.getTitulo());
        rating.setDescricaoAvaliacao(ratingDTO.getDescricaoAvaliacao());
        User usu = new User();
        usu.setId(ratingDTO.getUsuarioId());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(ratingDTO.getVeiculoId());
        rating.setVeiculo(vehicle);
        rating.setUsuario(usu);
        repository.save(rating);
    }

    @Override
    public List<RatingDTO> listRatingsByVehicleId(Integer id) {
        return repository.findByVeiculoId(id);
    }
}
