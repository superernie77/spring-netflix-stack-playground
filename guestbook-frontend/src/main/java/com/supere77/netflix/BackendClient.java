package com.supere77.netflix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("BACKEND") // name of service in eureka
public interface BackendClient {
	
	// method equals the one you want to call in the backend. use full path to backend rest servcie "/guestbook/"
	@RequestMapping(value = "/guestbook/" , method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GuestbookEntry> create(GuestbookEntry entry);

}
