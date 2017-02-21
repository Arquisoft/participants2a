package uo.asw.participants.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uo.asw.participants.util.CitizenMin;

@Controller
public class WebController {

	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		// model.addAttribute("nombre","luis");
		return "log";
	}

	@Autowired
	CitzenController cc;

	@RequestMapping(value = "/info", method = RequestMethod.GET, params = { "user", "password" })
	public ModelAndView showInfo(@RequestParam(value = "user") String username,
			@RequestParam(value = "password") String password) {
		Map<String, Object> mp = new HashMap<>();
		mp.put("login", username);
		mp.put("password", password);
		ResponseEntity<CitizenMin> c = cc.getCitzen(mp);
		if(c.getStatusCode()!=HttpStatus.OK)
			return new ModelAndView("error");
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("name",c.getBody().getFirstName());
		mv.addObject("mail",c.getBody().getEmail());
		// TODO: añadir el resto de info del citizen.
		return mv;
	}
	
	
	

}