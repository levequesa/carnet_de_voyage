package com.ws.carnetDeVoyage.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.service.EtapeService;


@Controller
public class EtapeController  {
	
	@Autowired
	private EtapeService etapeService;
	
	@GetMapping("/travels/{travelId}")
	public String findAllEtapes(Model model, @PathVariable(required = false) Long travelId){
	       Travel travel = new Travel();
	        if (travelId != null)
	        {
//	            Optional<Etape> etape =etapeService.findById(travelId);
//	            if (Optional.isPresent()) {
//	                expenseList = OptionalExpenseList.get();
//	            }
	        }
//	        model.addAttribute("expenseList", expenseList);
//	        model.addAttribute("participants", expenseList.getParticipants());
		return "etapes";
	}
	
}