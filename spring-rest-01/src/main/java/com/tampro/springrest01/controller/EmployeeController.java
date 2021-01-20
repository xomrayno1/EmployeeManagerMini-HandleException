package com.tampro.springrest01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tampro.springrest01.exception.ApplicationException;
import com.tampro.springrest01.model.request.CreateEmpRequest;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
import com.tampro.springrest01.response.EmployeeResponse;
import com.tampro.springrest01.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	
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
			return new ResponseEntity<APIResponse>(
					new APIResponse<List<EmployeeResponse>>(listEmpResponse, APIStatus.OK),
					HttpStatus.OK);
		}	
	}
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getEmp(@PathVariable("id") long id){
		Employee employee = empService.getById(id);
		if(employee == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<EmployeeResponse>(new EmployeeResponse(employee), APIStatus.OK),
				HttpStatus.OK
				);
	}
	@PostMapping
	public ResponseEntity<APIResponse> createEmp(@RequestBody CreateEmpRequest empRequest){
		 if(empService.isExists(empRequest.getCode())) {
			 throw new ApplicationException(APIStatus.ERR_CODE_EXISTS);
		 }else {
			 Employee employee = empService.createEmployee(empRequest);
			 return new ResponseEntity<APIResponse>(
					 new APIResponse<EmployeeResponse>(new EmployeeResponse(employee), APIStatus.CREATED),
					 HttpStatus.CREATED);
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
			 return new ResponseEntity<APIResponse>(
					 new APIResponse<EmployeeResponse>(new EmployeeResponse(newEmp), APIStatus.OK),
					 HttpStatus.OK
					 );
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
			 return new ResponseEntity<APIResponse>(
					 new APIResponse<EmployeeResponse>(new EmployeeResponse(employee), APIStatus.OK),
					 HttpStatus.OK
					 );
		 }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> deleteEmp(@PathVariable("id") long id){
		Employee employee = empService.getById(id);
		 if(employee == null) {
			 throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		 }else {
			 return new ResponseEntity<APIResponse>(
					 new APIResponse<Employee>(null, APIStatus.OK),
					 HttpStatus.OK);
		 }
	}
	

}
////https://petstore.swagger.io/#/