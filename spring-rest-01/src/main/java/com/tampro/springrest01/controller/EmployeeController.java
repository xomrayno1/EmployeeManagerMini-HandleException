package com.tampro.springrest01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.exception.ApplicationException;
import com.tampro.springrest01.model.request.CreateEmpRequest;
import com.tampro.springrest01.model.request.EmployeePagingSearchSortModel;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
import com.tampro.springrest01.response.EmployeeResponse;
import com.tampro.springrest01.service.EmployeeService;
import com.tampro.springrest01.service.TeamService;
import com.tampro.utils.ResponseUtils;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	TeamService teamService;
	
	ResponseUtils responseUtil = new ResponseUtils();
	
	@PostMapping("/get_list_sort_search_paging_filter")
	public ResponseEntity<APIResponse> 
				getListPagingSortSearchAndFilter(@RequestBody EmployeePagingSearchSortModel empModel){
		try {
			Page<Employee> pageEmp = empService.doFilterSearchSortPagingEmployee(empModel.getSearchKey(),
					empModel.getSortKey(), empModel.isAscSort(), empModel.getPageNumber(), empModel.getPageSize());
			if(pageEmp != null) {
				return responseUtil.successResponse(pageEmp);
			}else {
				throw new ApplicationException(APIStatus.ERR_EMPLOYEE_LIST_IS_EMPTY);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_LIST_IS_EMPTY);
		}
 
	}
	@GetMapping
	public ResponseEntity<APIResponse> getAllEmp(){
		List<Employee> list  = empService.getAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			List<EmployeeResponse> listEmpResponse 
									= new ArrayList<EmployeeResponse>();
			list.forEach(item->{
				listEmpResponse.add(new EmployeeResponse(item));
			});
			return responseUtil.successResponse(list);
		}	
	}
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getEmp(@PathVariable("id") long id){
		Employee employee = empService.getById(id);
		if(employee == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		}
		return  responseUtil.successResponse(employee);
	}
	@PostMapping
	public ResponseEntity<APIResponse> createEmp(@RequestBody CreateEmpRequest empRequest){
		 if(empService.isExists(empRequest.getCode())) {
			 throw new ApplicationException(APIStatus.ERR_CODE_EXISTS);
		 }else {
			 Employee employee = empService.createEmployee(empRequest);
			 return responseUtil.successResponse("create employee successfully");
		 }
	}
	@PutMapping("/{id}")
	public ResponseEntity<APIResponse> updateEmp(@PathVariable("id") long id
										,@RequestBody Employee empRequest){
		Employee employee = empService.getById(id);
		 if(employee == null) {
			 throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		 }else {
			 if(empRequest.getCode() != null) {
				 employee.setCode(empRequest.getCode());
			 }
			 if(empRequest.getPhone() != null) {
				 employee.setPhone(empRequest.getPhone());
			 }
			 if(empRequest.getFirstName() != null) {
				 employee.setFirstName(empRequest.getFirstName());
			 }
			 if(empRequest.getLastName() != null) {
				 employee.setLastName(empRequest.getLastName());
			 }
			 Employee newEmp = empService.updateEmployee(employee);
			 return  responseUtil.successResponse(newEmp);
		 }
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<APIResponse> updateFistNameEmp(@PathVariable("id") long id
			,Employee empRequest){
		Employee employee = empService.getById(id);
		 if(employee == null) {
			 throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		 }else {
 
			 if(empRequest.getFirstName() != null) {
				 employee.setFirstName(empRequest.getFirstName());
			 }
 
			 Employee  newEmp = empService.updateEmployee(employee);
			 return responseUtil.successResponse(newEmp);
		 }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> deleteEmp(@PathVariable("id") long id){
		Employee employee = empService.getById(id);
		 if(employee == null) {
			 throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		 }else {
			 return responseUtil.successResponse("successfully");
		 }
	}
	@GetMapping("/team/{teamId}")
	public ResponseEntity<APIResponse> getEmpByTeam(@PathVariable("teamId") long teamId){
		Team team = teamService.getById(teamId);
		if(team == null) {
			throw new ApplicationException(APIStatus.ERR_TEAM_ID_NOT_EXISTS);
		}else {
			List<Employee> employees = empService.getByTeam(team);
			if(employees.isEmpty()) {
				throw new ApplicationException(APIStatus.ERR_EMPLOYEE_LIST_IS_EMPTY);
			}
			return  responseUtil.successResponse(team);
		}
		 
	}

}
////https://petstore.swagger.io/#/