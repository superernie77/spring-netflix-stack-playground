package com.supere77.netflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MailSender sender;
	
	@Value("${mail.from}")
	private String from;
	
	@Value("${mail.to}")
	private String to;
	
	@RequestMapping(value = "/" , method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendMail(@RequestBody GuestbookEntry entry){
		
		SimpleMailMessage m = new SimpleMailMessage();
		m.setTo(to);
		m.setFrom(from);
		m.setSubject(entry.getTitle());
		m.setText(entry.getText());
		
		sender.send(m);
		
		return ResponseEntity.ok().build();
	}

}
