package br.com.amsj.simpleapi.controller;

import java.text.SimpleDateFormat;
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
		
		log.info("Init");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("Error on thread sleep" + e.getMessage());
		}
		
		ResponseEntity<String> responseEntity = null;
		
		if(!HttpStatusSignal.is_health) {
			log.error("HttpStatusSignal.is_health: " + HttpStatusSignal.is_health);
			return responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Date date = new Date();
	
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
		String dateString = dt1.format (date);
		
		log.info("Success");
		
		responseEntity = new ResponseEntity<String>(dateString, HttpStatus.OK);
		
		return responseEntity;
	}
}
