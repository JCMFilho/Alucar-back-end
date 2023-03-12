package com.api.aluguelcarro.model.repository;

import com.api.aluguelcarro.model.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RentRepository  extends CrudRepository<Rent, Integer> {

    @Query("SELECT new com.api.aluguelcarro.model.RentDTO(r) FROM Rent r WHERE r.usuario.id =:id")
    List<RentDTO> getRentById(@Param("id") Integer id);

    @Query("SELECT r FROM Rent r WHERE r.usuario.id =:usuario AND r.veiculo.id =:veiculo")
    List<Rent> getRentByUserAndVehicleId(@Param("usuario") Integer usuario, @Param("veiculo") Integer veiculo);

    @Query("Select new com.api.aluguelcarro.model.RentListDTO(r) FROM Rent r  WHERE r.usuario.name LIKE %:nome% AND r.dataInicio >= :dataInicial AND r.dataFim <=:dataFinal order by r.id desc")
    List<RentListDTO> getRentListForManagement(@Param("nome") String nome, @Param("dataInicial") Timestamp dataInicial, @Param("dataFinal") Timestamp dataFinal);

    @Query("SELECT new com.api.aluguelcarro.model.EstatisticaVeiculoDTO(COUNT(a), a.veiculo.nome, a.veiculo.fabricante) FROM Rent a GROUP BY a.veiculo.id ORDER BY COUNT(a) DESC")
    List<EstatisticaVeiculoDTO> getTopRentVehicle();

    @Query("SELECT new com.api.aluguelcarro.model.EstatisticaChart(COUNT(a), a.status) FROM Rent a GROUP BY a.status ORDER BY a.status")
    List<EstatisticaChart> getRentDashboard();

    long count();
}

