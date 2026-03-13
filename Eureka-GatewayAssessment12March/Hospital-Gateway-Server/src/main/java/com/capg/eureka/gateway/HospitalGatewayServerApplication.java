package com.capg.eureka.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalGatewayServerApplication.class, args);
		System.out.println("Hospital gateway has started ......");
	}

}
