package com.api.aluguelcarro.service;

import java.util.List;

import com.api.aluguelcarro.model.Vehicle;
import com.api.aluguelcarro.model.VehicleDTO;

public interface IVehicleService {

	Vehicle saveVehicle(Vehicle veiculo);

	VehicleDTO getVehicle(Integer id);
	
	List<VehicleDTO> getVehicleHomePage();

    List<VehicleDTO> getVehicles(String nome, String cidade, String fabricante);

    void deleteVehicle(Integer vehicleId);
}
