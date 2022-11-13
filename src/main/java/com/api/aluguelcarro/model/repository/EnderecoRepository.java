package com.api.aluguelcarro.model.repository;

import com.api.aluguelcarro.model.Endereco;
import com.api.aluguelcarro.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

//    @Query("Select e from endereco e where e.usuarioId =:id")
//    public Endereco getEnderecoByUser(@Param("id") Integer id);

    Endereco findByUsuarioId(Integer usuarioId);

}
