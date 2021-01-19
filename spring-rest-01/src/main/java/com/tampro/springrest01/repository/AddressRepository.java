package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
	@Override
	List<Address> findAll();
	
	

}
