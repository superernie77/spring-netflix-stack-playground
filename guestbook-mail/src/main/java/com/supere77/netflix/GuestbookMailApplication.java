package com.supere77.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class GuestbookMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookMailApplication.class, args);
	}
}
