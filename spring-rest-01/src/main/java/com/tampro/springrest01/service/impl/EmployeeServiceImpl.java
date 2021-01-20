package com.tampro.springrest01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Role;
import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.model.request.CreateEmpRequest;
import com.tampro.springrest01.repository.EmployeeRepository;
import com.tampro.springrest01.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository empRepo;
	@Override
	public Employee createEmployee(CreateEmpRequest createEmpRequest) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setBirthDay(createEmpRequest.getBirthDay());
		employee.setCode(createEmpRequest.getCode());
		employee.setFirstName(createEmpRequest.getFirstName());
		employee.setLastName(createEmpRequest.getLastName());
		employee.setPhone(createEmpRequest.getPhone());
		employee.setRole(Role.valueOf(createEmpRequest.getRole()));
		employee.setTeam(new Team(createEmpRequest.getTeamId()));
		employee.setCode(createEmpRequest.getCode());
		 
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.delete(employee);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		 
		return empRepo.findAll();
	}

	@Override
	public List<Employee> getByTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		 
		return  empRepo.findById(id).orElse(null);
	}

	@Override
	public boolean isExists(String code) {
		// TODO Auto-generated method stub
		return (empRepo.findByCode(code) != null ) ? true : false;
	}

}
