package com.tampro.springrest01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.repository.AddressRepository;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressRepository addressRepo;
	

	@Override
	public APIResponse<Address> createAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIResponse<Address> updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
