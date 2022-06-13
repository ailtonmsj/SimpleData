package br.com.amsj.simpleapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.amsj.simpleapi.helper.ErrorControl;
import br.com.amsj.simpleapi.helper.HttpStatusSignal;

@RestController
public class DateController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ErrorControl errorControl;
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public ResponseEntity<String> getCurrentDate() {
		
		ResponseEntity<String> responseEntity = null;
		
		log.info("Init");
		//log.info("errorControl.getContador() - " + errorControl.getContador());
		
		// DOCKER IMAGE: 7:random-error
		//if (errorControl.getContador() == 4) {
            // Incrementar o contador ao final
			//errorControl.incrementaContador();
		
			
			// DOCKER IMAGE: 6:delay
			//try {
			//	Thread.sleep(2000);
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//	log.error("Error on thread sleep" + e.getMessage());
			//}
			
			//DOCKER IMAGE: 8:controlserverstatus
			if(!HttpStatusSignal.is_health) {
				log.error("HttpStatusSignal.is_health: " + HttpStatusSignal.is_health);
				return responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			Date date = new Date();
		
			SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dateString = dt1.format (date);
			
			log.info("Success");
			
			responseEntity = new ResponseEntity<String>(dateString, HttpStatus.OK);
			
			return responseEntity;
		
//		} else {
            // Se for diferente de 4 (ou seja 1, 2 e 3), então retorno algo diferente de 200
            // e incrementa o contador
			//errorControl.incrementaContador();
//			log.info("Error");
//            return responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
}
