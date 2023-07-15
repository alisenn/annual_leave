package com.demo.annual_leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.demo.annual_leave.repository"})

public class AnnualLeaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnualLeaveApplication.class, args);
	}

}
