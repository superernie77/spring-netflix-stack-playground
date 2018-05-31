package com.supere77.netflix;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
	public ModelAndView addEntry(@Valid GuestbookEntry entry) throws InterruptedException, ExecutionException {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestbook");
        
        // call with circuitbreaker
        Future<Boolean> done = backendService.create(entry);
        
        
        // direct call with feign client
        //backendClient.create(entry);
        
        // wait for insert to be finished before reading
        // Hysterix call is async
        List<GuestbookEntry> entries = null;
        if (done.get()) {
        	entries = backendClient.getAll().getBody();	
        
        }
        
	    modelAndView.addObject("entries", entries);
        
        modelAndView.addObject("entry", new GuestbookEntry());
        return modelAndView;
	}

}
