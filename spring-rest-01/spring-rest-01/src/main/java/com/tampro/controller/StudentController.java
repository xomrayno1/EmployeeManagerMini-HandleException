package com.tampro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.response.StudentResponse;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@GetMapping("/get")
	public StudentResponse getStudent() {
		StudentResponse studentResponse = new StudentResponse(1,"Nguyen","Tam");
	 
		return studentResponse;
	}
}
