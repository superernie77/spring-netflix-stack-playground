package com.supere77.netflix;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestbookController {
	
	
	private static final String EXCHANGE_URL = "http:localhost:8080/guestbook";

	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value = {"/guestbook"}, method = RequestMethod.GET)
	public ModelAndView showGuestbook() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
       // ResponseEntity<List<GuestbookEntry>> rateResponse =
       //         restTemplate.exchange(EXCHANGE_URL,
       //                     HttpMethod.GET, null, new ParameterizedTypeReference<List<GuestbookEntry>>() {});
       // List<GuestbookEntry> entries = rateResponse.getBody();
       // modelAndView.addObject("entries", entries);
        modelAndView.addObject("entry", new GuestbookEntry());
        
        return modelAndView;
	}
	
	@RequestMapping(value = {"/guestbook"}, method = RequestMethod.POST)
	public ModelAndView addEntry(@Valid GuestbookEntry entry) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        //restTemplate.postForObject(EXCHANGE_URL, entry, String.class);
        modelAndView.addObject("entry", new GuestbookEntry());
        return modelAndView;
	}

}
