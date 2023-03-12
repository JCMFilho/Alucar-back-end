package com.api.aluguelcarro.service.impl;

import com.api.aluguelcarro.model.Endereco;
import com.api.aluguelcarro.model.repository.EnderecoRepository;
import com.api.aluguelcarro.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService {

    @Autowired
    EnderecoRepository repository;

    @Override
    public Endereco getEnderecoByUser(Integer id) {
        return repository.findByUsuarioId(id);
    }

    @Override
    public Endereco saveEndereco(Endereco endereco) {
        return repository.save(endereco);
    }
}
