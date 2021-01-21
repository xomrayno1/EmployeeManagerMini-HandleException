package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
	@Override
	List<Address> findAll();
	
	List<Address> findByEmployee(Employee employee);
	

}
