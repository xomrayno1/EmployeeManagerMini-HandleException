package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Team;

@Repository
public interface EmployeeRepository  extends PagingAndSortingRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{
	@Override
	List<Employee> findAll();
	
	Employee findByCode(String code);
	
	List<Employee> findByTeam(Team team);
}
