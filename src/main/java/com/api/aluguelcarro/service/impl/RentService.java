package com.api.aluguelcarro.service.impl;

import com.api.aluguelcarro.model.*;
import com.api.aluguelcarro.model.repository.RentRepository;
import com.api.aluguelcarro.service.IRentService;
import com.api.aluguelcarro.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class RentService implements IRentService {

    @Autowired
    private RentRepository repository;

    @Override
    public void cadastrarAluguel(RentDTO rentDto) throws ParseException {
        Rent rent = new Rent();
        rent.setDataAluguel(Timestamp.from(Instant.now()));
        rent.setStatus(StatusAluguel.EM_ANDAMENTO);
        rent.setDataInicio(DateUtil.stringDateToTimestamp(rentDto.getDataInicio().substring(0,10) + " 00:00:00"));
        rent.setDataFim(DateUtil.stringDateToTimestamp(rentDto.getDataFim().substring(0,10) + " 23:59:59"));
        rent.setMeioPagamento(rentDto.getMeioPagamento());
        rent.setValorTotal(rentDto.getValorTotal());
        User usu = new User();
        usu.setId(rentDto.getIdUsuario());
        rent.setUsuario(usu);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(rentDto.getIdVeiculo());
        rent.setVeiculo(vehicle);
        repository.save(rent);
    }

    @Override
    public List<RentDTO> getRentsByUserId(Integer id) {
        return repository.getRentById(id);
    }

    @Override
    public void atualizarEstadoAluguel(Integer id,StatusAluguel status) {
        Optional<Rent> rent = repository.findById(id);
        if(rent.isPresent()){
            Rent r = rent.get();
            r.setStatus(status);
            repository.save(r);
        }
    }



    @Override
    public List<RentListDTO> getRentListForManagement(String dataInicial, String dataFinal, String nome) throws ParseException {
        return repository.getRentListForManagement(nome,DateUtil.stringDateToTimestamp( dataInicial + " 00:00:00"),
                    DateUtil.stringDateToTimestamp(dataFinal + " 23:59:59"));
    }
}
