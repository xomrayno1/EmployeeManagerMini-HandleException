package com.tampro.springrest01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;
import com.tampro.springrest01.model.request.CreateAddressRequest;
import com.tampro.springrest01.model.request.UpdateAddressRequest;
import com.tampro.springrest01.repository.AddressRepository;
import com.tampro.springrest01.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressRepository addressRepo;
	

	@Override
	public Address createAddress(CreateAddressRequest car) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setDistrict(car.getDistrict());
		address.setEmployee(new Employee(car.getEmpId()));
		address.setProvince(car.getProvince());
		address.setStreet(car.getStreet());
		return addressRepo.save(address);
	}

	@Override
	public Address updateAddress(UpdateAddressRequest uar) {
		// TODO Auto-generated method stub
		Address address = addressRepo.findById(uar.getId()).orElse(null);
		if(address != null) {
			address.setDistrict(uar.getDistrict());
			address.setEmployee(new Employee(uar.getEmpId()));
			address.setId(uar.getId());
			address.setProvince(uar.getProvince());
			address.setStreet(uar.getStreet());
			addressRepo.save(address);
		}
		return address;
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
		
		return addressRepo.findByEmployee( employee);
	}

	@Override
	public Address getById(long id) {
		// TODO Auto-generated method stub
		return addressRepo.findById(id).orElse(null);
	}

	  

}
