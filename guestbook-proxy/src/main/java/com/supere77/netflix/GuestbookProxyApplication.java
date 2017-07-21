package com.supere77.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GuestbookProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookProxyApplication.class, args);
	}
}
