package uo.asw.participants.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import uo.asw.participants.Participants.util.CitizenMin;


import java.util.Map;


public interface CitzenController {

	public ResponseEntity<CitizenMin> getCitzen(Map<String, Object> payload);
}
