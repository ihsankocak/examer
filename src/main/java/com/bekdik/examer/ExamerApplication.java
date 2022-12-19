package com.bekdik.examer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bekdik.examer.controller","com.bekdik.examer.service"})

public class ExamerApplication {

	public static void main(String[] args) {
	SpringApplication.run(ExamerApplication.class, args);
		
	}

}
