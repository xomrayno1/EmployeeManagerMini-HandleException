package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Long>{
	@Override
	List<Employee> findAll();
}
