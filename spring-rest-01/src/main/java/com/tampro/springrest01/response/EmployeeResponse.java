package com.tampro.springrest01.response;

import java.util.Date;
import java.util.List;

import com.tampro.springrest01.entity.Address;
import com.tampro.springrest01.entity.Employee;

public class EmployeeResponse {
	private long id;
	private String firstName;
	private String lastName;
	private Date birthDay;
	private String phone;
	private String role;
	private String code;
	private List<Address> listAddress;
	private long teamId;
	private String teamName;
	
	
	
	
	public EmployeeResponse() {
		 
	}
	public EmployeeResponse(Employee employee) {
		 
		if(employee != null) {
			this.id = employee.getId();
			this.firstName = employee.getFirstName();
			this.lastName = employee.getLastName();
			this.birthDay = employee.getBirthDay();
			this.phone = employee.getPhone();
			this.role = employee.getRole().toString();
			this.code = employee.getCode();
			this.listAddress =employee.getAddress();
			this.teamId = employee.getTeam().getId();
			this.teamName = employee.getTeam().getName();
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Address> getListAddress() {
		return listAddress;
	}
	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
}
