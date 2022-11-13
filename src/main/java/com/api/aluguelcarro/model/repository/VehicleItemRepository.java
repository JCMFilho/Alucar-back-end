package com.api.aluguelcarro.model.repository;

import com.api.aluguelcarro.model.VehicleItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleItemRepository extends CrudRepository<VehicleItem, Integer> {
}
