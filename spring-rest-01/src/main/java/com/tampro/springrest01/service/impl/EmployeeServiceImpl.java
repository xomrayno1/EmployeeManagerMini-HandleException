package com.tampro.springrest01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.repository.EmployeeRepository;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository empRepo;
	@Override
	public APIResponse<Employee> createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIResponse<Employee> updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getByTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
