package com.api.aluguelcarro.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.aluguelcarro.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
