package com.tampro.springrest01.model.request;

public class CreateAddressRequest {
	private String street;
	private String province;
	private String district;
	private long empId;
	
	
	public CreateAddressRequest() {
		 
	}
	public CreateAddressRequest(String street, String province, String district, long empId) {
		 
		this.street = street;
		this.province = province;
		this.district = district;
		this.empId = empId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	
}
