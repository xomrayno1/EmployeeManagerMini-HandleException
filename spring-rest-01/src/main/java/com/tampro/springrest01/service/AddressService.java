package com.tampro.springrest01.service;

import java.util.List;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.response.APIResponse;

public interface AddressService {
	
	APIResponse<Address> createAddress(Address address);
	APIResponse<Address> updateAddress(Address address);
	void deleteAddress(Address address);
	List<Address> getAll();
	List<Address> getByEmployee(Employee employee);
	Employee getById(long id);

}
