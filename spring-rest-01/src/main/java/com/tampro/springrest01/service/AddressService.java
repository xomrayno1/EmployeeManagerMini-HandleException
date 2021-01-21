package com.tampro.springrest01.service;

import java.util.List;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.model.request.CreateAddressRequest;
import com.tampro.springrest01.model.request.UpdateAddressRequest;

public interface AddressService {
	
	Address createAddress(CreateAddressRequest car);
	Address updateAddress(UpdateAddressRequest uar);
	void deleteAddress(Address address);
	List<Address> getAll();
	List<Address> getByEmployee(Employee employee);
	Address getById(long id);

}
