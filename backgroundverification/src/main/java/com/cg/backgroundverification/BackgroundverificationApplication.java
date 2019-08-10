package com.cg.backgroundverification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg")
public class BackgroundverificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackgroundverificationApplication.class, args);
	}

}
