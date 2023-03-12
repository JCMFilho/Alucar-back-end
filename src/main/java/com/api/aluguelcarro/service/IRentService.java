package com.api.aluguelcarro.service;

import com.api.aluguelcarro.model.RentDTO;
import com.api.aluguelcarro.model.RentListDTO;
import com.api.aluguelcarro.model.StatusAluguel;

import java.text.ParseException;
import java.util.List;

public interface IRentService {

    public void cadastrarAluguel(RentDTO rentDto) throws ParseException;

    public List<RentDTO> getRentsByUserId(Integer id);

    public void atualizarEstadoAluguel(Integer id, StatusAluguel status);


    public List<RentListDTO> getRentListForManagement(String dataInicial, String dataFinal, String nome) throws ParseException;
}
