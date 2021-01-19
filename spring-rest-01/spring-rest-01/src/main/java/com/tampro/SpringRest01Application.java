package com.tampro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.tampro.entity")
public class SpringRest01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRest01Application.class, args);
	}

}
