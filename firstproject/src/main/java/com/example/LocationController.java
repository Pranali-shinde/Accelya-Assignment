package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.Status;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/client")
public class LocationController {

	public static final Logger LOGGER = LogManager.getLogger(LocationController.class);

	@Autowired
	private LocationService locationService;
	
	Map<String,Double> locationMap ;

	 @GetMapping("/getlocation")
	  public Map<String,Double> getLocationOfSatellite() throws Exception {
		 final String method = "getLocationOfSatellite-Controller";
		    LOGGER.info("Entering " + method);
	    locationMap = locationService.getCoordinatesOfSpaceStation();
	    LOGGER.info("Moving Out " + method);
	    return locationMap;
	  }	
}
