package com.api.aluguelcarro.service;

import com.api.aluguelcarro.model.Endereco;

public interface IEnderecoService {

    public Endereco getEnderecoByUser(Integer id);

    public Endereco saveEndereco(Endereco endereco);
}
