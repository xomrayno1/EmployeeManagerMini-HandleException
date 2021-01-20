package com.tampro.springrest01.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.model.request.CreateEmpRequest;

public interface EmployeeService {
	Employee createEmployee(CreateEmpRequest createEmpRequest);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	List<Employee> getAll();
	List<Employee> getByTeam(Team team);
	Employee getById(long id);
	boolean isExists(String code);
	
	public Page<Employee> doFilterSearchSortPagingEmployee(String searchKey,
			int sortKey,boolean ascSort,int pageNumber,int pageSize);
}
