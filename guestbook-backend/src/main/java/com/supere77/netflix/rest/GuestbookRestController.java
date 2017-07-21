package com.supere77.netflix.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supere77.netflix.domain.GuestbookEntry;
import com.supere77.netflix.repository.GuestbookRepository;

@RestController
@RequestMapping(value = "/guestbook")
@CrossOrigin(origins = "*")
public class GuestbookRestController {
	
	
	@Autowired
	private GuestbookRepository repository;
	
	@RequestMapping(value = "/" , method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(GuestbookEntry entry){
		repository.save(entry);
		return ResponseEntity.ok(entry);
	}
	
	@RequestMapping(value = "/" , method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
}
