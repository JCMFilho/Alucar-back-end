package com.api.aluguelcarro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.api.aluguelcarro.model.VehicleDTO;
import com.api.aluguelcarro.model.VehicleItem;
import com.api.aluguelcarro.model.repository.VehicleItemRepository;
import com.api.aluguelcarro.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.aluguelcarro.model.Vehicle;
import com.api.aluguelcarro.model.repository.VehicleRepository;
import com.api.aluguelcarro.service.IVehicleService;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    VehicleRepository repository;

    @Autowired
    VehicleItemRepository itemRepository;

    @Override
    public Vehicle saveVehicle(Vehicle veiculo) {
        Vehicle vehicleToSave = new Vehicle(veiculo.getId(), veiculo.getNome(), veiculo.getCidade(), veiculo.getAno(), veiculo.getKm(), veiculo.getCambio(), veiculo.getFabricante(), StringUtils.isEmpty(veiculo.getData()) ? DateUtil.getCurrentDate() : veiculo.getData(), veiculo.getCarroceria(), veiculo.getCombustivel(), veiculo.getFinalPlaca(), veiculo.getDiaria(), veiculo.getImagem(), veiculo.getCor());
        vehicleToSave = repository.save(vehicleToSave);
        Vehicle finalVehicleToSave = vehicleToSave;
        Set<VehicleItem> items = veiculo.getItemVeiculos().stream().map(item -> {
            VehicleItem itemVeiculo = new VehicleItem();
            itemVeiculo.setDescricao(item.getDescricao());
            itemVeiculo.setVehicle(finalVehicleToSave);
            itemVeiculo.setId(item.getId());
            return itemVeiculo;
        }).collect(Collectors.toSet());
        itemRepository.saveAll(items);
        return vehicleToSave;
    }

    @Override
    public VehicleDTO getVehicle(Integer id) {
        return new VehicleDTO(repository.findById(id).orElse(new Vehicle()));
    }

	@Override
	public List<VehicleDTO> getVehicleHomePage() {
		return ((List<Vehicle>) repository.findAll()).stream().map(VehicleDTO::new).collect(Collectors.toList());
	}

    @Override
    public List<VehicleDTO> getVehicles(String nome, String cidade, String fabricante) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles = repository.getVehiclesByFilter(nome, cidade, fabricante);

        return vehicles.stream().map(VehicleDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Integer vehicleId) {
        repository.deleteById(vehicleId);
    }


}
