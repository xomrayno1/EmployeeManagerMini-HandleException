package com.tampro.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
 
 

public class StudentResponse {
	
	@JsonIgnore
	private long id;
	@JsonProperty(value = "first_name")
	private String firstName;
	@JsonProperty(value = "last_name")
	private String lastName;
	
	
	
	public StudentResponse() {
		 
	}
	public StudentResponse(long id, String firstName, String lastName) {
		 
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
 
	

}
