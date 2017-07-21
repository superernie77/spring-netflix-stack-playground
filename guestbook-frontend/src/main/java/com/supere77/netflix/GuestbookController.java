package com.supere77.netflix;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class GuestbookController {
	
	@Autowired
	private BackendClient backendClient;
	
	@PostConstruct
	public void config() {
		restTemplate = new RestTemplate();
	}
	
	private static final String EXCHANGE_URL = "http://localhost:8000/guestbook/";

	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView showGuestbook() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(EXCHANGE_URL);
        
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<?> request = new HttpEntity(null, headers);
        
        ResponseEntity<List<GuestbookEntry>> rateResponse =
                restTemplate.exchange(builder.build().encode().toUriString(),
                            HttpMethod.GET, request, new ParameterizedTypeReference<List<GuestbookEntry>>() {});
        List<GuestbookEntry> entries = rateResponse.getBody();
        modelAndView.addObject("entries", entries);
        modelAndView.addObject("entry", new GuestbookEntry());
        
        return modelAndView;
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public ModelAndView addEntry(@Valid GuestbookEntry entry) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        
        // webservce call with Feign-Client
        backendClient.create(entry);
        
        // call with RestTemplate
        /*
         * UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(EXCHANGE_URL);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		HttpEntity<?> request = new HttpEntity(entry, headers);
		
		 restTemplate.exchange(builder.build().encode().toUriString(),
				 HttpMethod.POST, request, GuestbookEntry.class);
         */
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(EXCHANGE_URL);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json"); 
		HttpEntity<?> request = new HttpEntity(null, headers);
		ResponseEntity<List<GuestbookEntry>> rateResponse =
	                restTemplate.exchange(builder.build().encode().toUriString(),
	                            HttpMethod.GET, request, new ParameterizedTypeReference<List<GuestbookEntry>>() {});
		 List<GuestbookEntry> entries = rateResponse.getBody();
	        modelAndView.addObject("entries", entries);
        
        modelAndView.addObject("entry", new GuestbookEntry());
        return modelAndView;
	}

}
