package br.com.amsj.simpleapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.amsj.simpleapi.helper.HttpStatusSignal;

@RestController
public class ResponseCodeController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET, path="/healthstatus")
	public boolean setResponseCode(@RequestParam(name = "isHealth") boolean isHealth ) {
		
			log.info("Appplication health status: " + isHealth);
			HttpStatusSignal.is_health = isHealth;
		return isHealth;
	}
}
