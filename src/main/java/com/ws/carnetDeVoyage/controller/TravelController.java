package com.ws.carnetDeVoyage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.service.TravelService;

@Controller
public class TravelController  {
	
	@Autowired
	private TravelService travelService;
	
	@GetMapping("/travels")
	public String getAllTravel(Model model) {
		model.addAttribute("travel",travelService.findAll());
	 	return "travels";
	}
	
	@GetMapping("/admin")
	public String getAdminPortail(Model model) {
		return "admin";
	}
	
	@PostMapping("/admin/travelNew")
	public String addTravel(@ModelAttribute Travel travel) {
		travelService.save(travel);
		return "redirect:/admin";
	}
}