package com.api.aluguelcarro.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.aluguelcarro.model.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    @Query("Select v from Vehicle v WHERE v.nome LIKE %:nome% AND v.cidade LIKE %:cidade% AND v.fabricante LIKE %:fabricante%")
    public List<Vehicle> getVehiclesByFilter(@Param("nome") String nome, @Param("cidade") String cidade, @Param("fabricante") String fabricante);
}
