package com.api.aluguelcarro.model.repository;

import com.api.aluguelcarro.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

    Endereco findByUsuarioId(Integer usuarioId);

}
