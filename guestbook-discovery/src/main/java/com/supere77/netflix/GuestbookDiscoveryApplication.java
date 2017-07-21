package com.supere77.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GuestbookDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookDiscoveryApplication.class, args);
	}
}
