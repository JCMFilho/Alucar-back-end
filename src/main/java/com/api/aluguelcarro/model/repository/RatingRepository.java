package com.api.aluguelcarro.model.repository;

import com.api.aluguelcarro.model.Rating;
import com.api.aluguelcarro.model.RatingDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

    @Query("Select r FROM Rating r where r.usuario.id =:usuario AND r.veiculo.id =:veiculo")
    Rating findByUsuarioIdAndVeiculoId(@Param("usuario") Integer usuario, @Param("veiculo") Integer veiculo);


    @Query("Select new com.api.aluguelcarro.model.RatingDTO(r) FROM Rating r where r.veiculo.id =:veiculo")
    List<RatingDTO> findByVeiculoId(@Param("veiculo") Integer veiculo);
}
