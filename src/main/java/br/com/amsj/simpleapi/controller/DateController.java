package br.com.amsj.simpleapi.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amsj.simpleapi.helper.HttpStatusSignal;

@RestController
public class DateController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public ResponseEntity<String> getCurrentDate() {
		
		ResponseEntity<String> responseEntity = null;
		
		if(!HttpStatusSignal.is_health) {
			log.error("HttpStatusSignal.is_health: " + HttpStatusSignal.is_health);
			return responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String server = "";
		try {
			server = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		String data = server + " - " + new Date(); 
		
		log.info("Success");
		
		responseEntity = new ResponseEntity<String>(data, HttpStatus.OK);
		
		return responseEntity;
	}
}
