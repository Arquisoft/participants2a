package uo.asw.participants.controller.impl;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uo.asw.participants.controller.CitzenController;
import uo.asw.participants.model.Citizen;

@RestController
public class CitzenControllerImpl implements CitzenController {

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Citizen> getCitzen(@RequestBody String nombre, @RequestBody String password) {
		//Comprobar datos con la base, si es correcto 200 OK, incorrecto 404 NOT_FOUND
		return null;
		
	}

}
