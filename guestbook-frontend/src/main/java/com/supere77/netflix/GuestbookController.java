package com.supere77.netflix;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestbookController {
	
	@Autowired
	private BackendClient backendClient;
	
	@Autowired
	private BackendService backendService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView showGuestbook() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        
        modelAndView.addObject("entries", backendClient.getAll().getBody());

        modelAndView.addObject("entry", new GuestbookEntry());
        
        return modelAndView;
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public ModelAndView addEntry(@Valid GuestbookEntry entry) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        
        // call with circuitbreaker
        backendService.create(entry);
        
        
        // direct call with feign client
        //backendClient.create(entry);
        
	    modelAndView.addObject("entries", backendClient.getAll().getBody());
        
        modelAndView.addObject("entry", new GuestbookEntry());
        return modelAndView;
	}

}
