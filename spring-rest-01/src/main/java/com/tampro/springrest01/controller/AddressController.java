package com.tampro.springrest01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.exception.ApplicationException;
import com.tampro.springrest01.model.request.CreateAddressRequest;
import com.tampro.springrest01.model.request.UpdateAddressRequest;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
import com.tampro.springrest01.service.AddressService;
import com.tampro.springrest01.service.EmployeeService;
import com.tampro.utils.ResponseUtils;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AddressService addressService;
	
	ResponseUtils responseUtil = new ResponseUtils();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> getAddressById(@PathVariable("id") long id){
		Address address = 	addressService.getById(id);
		if(address == null) {
			throw new ApplicationException(APIStatus.ERR_ADDRESS_ID_NOT_EXISTS);
		}else {
			addressService.deleteAddress(address);
			return responseUtil.successResponse(address);
		}
	}
	@GetMapping("/emp/{empId}")
	public ResponseEntity<APIResponse> getAddressByUser(@PathVariable("empId") long empId){
		Employee employee = employeeService.getById(empId);
		if(employee == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		}else {
			List<Address> list = addressService.getByEmployee(employee);
			if(list.isEmpty()) {
				throw new ApplicationException(APIStatus.ERR_EMPLOYEE_LIST_IS_EMPTY);
			}else {
				return responseUtil.successResponse(list);
			}
		}	 
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<APIResponse> createAddress(@RequestBody CreateAddressRequest addressRequest){
		Employee employee = employeeService.getById(addressRequest.getEmpId());
		if(employee == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		}else {
			addressService.createAddress(addressRequest);
			return responseUtil.successResponse("create address with empId : "+addressRequest.getEmpId());
		}
	}
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<APIResponse> updateAddress(@RequestBody UpdateAddressRequest addressRequest){
		Employee employee = employeeService.getById(addressRequest.getEmpId());
		if(employee == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS);
		}else {
			addressService.updateAddress(addressRequest);
			return responseUtil.successResponse("update address with empId : "+addressRequest.getEmpId());
		}
	}

	
}
