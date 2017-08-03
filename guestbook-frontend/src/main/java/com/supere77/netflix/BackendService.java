package com.supere77.netflix;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class BackendService {
	
	@Autowired
	private BackendClient backendClient;
	
	@HystrixCommand(fallbackMethod = "createFallback" )
	public Future<Boolean> create(GuestbookEntry entry){
		AsyncResult<Boolean> a = new AsyncResult<Boolean>() {

			@Override
			public Boolean invoke() {
				System.out.println("Before create");
				// webservce call with Feign-Client
				backendClient.create(entry);
				System.out.println("After create");
				return true;
			}
			
		};
		
		return a;
	}
	
	public Boolean createFallback(GuestbookEntry entry){
		System.out.println("Fallback method for create called.");
		return false;
	}

}
