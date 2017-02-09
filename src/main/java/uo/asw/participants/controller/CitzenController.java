package uo.asw.participants.controller;

import org.springframework.http.ResponseEntity;



import uo.asw.participants.model.Citizen;

import java.util.Map;


public interface CitzenController {

	public ResponseEntity<Citizen> getCitzen(Map<String, Object> payload);
}
