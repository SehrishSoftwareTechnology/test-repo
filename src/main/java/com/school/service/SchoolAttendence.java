package com.school.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchoolAttendence {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolAttendence.class, args);
	}

	

}
