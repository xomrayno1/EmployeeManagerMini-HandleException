package com.tampro.springrest01.service;

import java.util.List;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.response.APIResponse;

public interface EmployeeService {
	APIResponse<Employee> createEmployee(Employee employee);
	APIResponse<Employee> updateEmployee(Employee employee);
	void deleteEmployee(Employee address);
	List<Employee> getAll();
	List<Employee> getByTeam(Team team);
	Employee getById(long id);
}
