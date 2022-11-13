package com.api.aluguelcarro.model.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.aluguelcarro.model.User;
import com.api.aluguelcarro.model.Vehicle;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

	 User findByEmail(String email);

	@Modifying(clearAutomatically = true)
	@Query("update User usu set usu.phone =:phone, usu.name =:name , usu.cpf =:cpf where usu.id =:id")
	void updateUser(@Param("id") Long id, @Param("phone") String phone, @Param("cpf") String cpf, @Param("name") String name);
}
