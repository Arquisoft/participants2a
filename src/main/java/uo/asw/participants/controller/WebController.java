package uo.asw.participants.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import uo.asw.dbManagement.CitizenDAO;
import uo.asw.dbManagement.model.Citizen;
import uo.asw.participants.util.CitizenMin;

@Controller
public class WebController {

	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		// model.addAttribute("nombre","luis");
		return "log";
	}

//	@Autowired
//	CitzenController cc;
//
//	@RequestMapping(value = "/info", method = RequestMethod.GET, params = { "user", "password" })
//	public ModelAndView showInfo(@RequestParam(value = "user") String username,
//			@RequestParam(value = "password") String password) {
//		Map<String, Object> mp = new HashMap<>();
//		mp.put("login", username);
//		mp.put("password", password);
//		ResponseEntity<CitizenMin> c = cc.getCitzen(mp);
//		if(c.getStatusCode()!=HttpStatus.OK)
//			return new ModelAndView("error");
//		ModelAndView mv = new ModelAndView("view");
//		mv.addObject("name",c.getBody().getFirstName());
//		mv.addObject("mail",c.getBody().getEmail());
//		// TODO: añadir el resto de info del citizen.
//		return mv;
//	}
	
	@Autowired
	private CitizenDAO cc;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET, params = { "user", "password" })
	public ModelAndView showInfo(HttpSession session, @RequestParam(value = "user") String username,
			@RequestParam(value = "password") String password) {
		Map<String, Object> mp = new HashMap<>();
		mp.put("login", username);
		mp.put("password", password);
		Citizen c = cc.getParticipant(username, password);
		//Es necesario guardar el usuario en la sesión para poder modificar sus datos
		session.setAttribute("citizen", c);
		if(c == null)
			return new ModelAndView("error");
		ModelAndView mv = new ModelAndView("view");
		mv.addObject("name",c.getNombre());
		mv.addObject("mail",c.getEmail());
		// TODO: añadir el resto de info del citizen.
		return mv;
	}
	
	@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
	public String changeInfo() {
		return "changeInfo";
	}
	
	
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changePassword(HttpSession session, @RequestParam String password,
			@RequestParam String newPassword, Model model) {
		Citizen c = (Citizen) session.getAttribute("citizen");
		if(c != null){
			System.out.println(c.getNombre());
		}
		System.out.println(password);
		System.out.println(newPassword);
		return "view";
	}
	
	

}