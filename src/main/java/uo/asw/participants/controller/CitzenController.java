package uo.asw.participants.controller;

import org.springframework.http.ResponseEntity;



import uo.asw.participants.model.Citizen;


public interface CitzenController {

	public ResponseEntity<Citizen> getCitzen(String nombre, String password);
}
