package br.com.amsj.simpleapi.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public String getCurrentDate() {
		
		String server = "";
		try {
			server = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		String data = server + " - " + new Date(); 
		
		log.info("Success");
		
		return data;
	}
}
