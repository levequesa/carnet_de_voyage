package com.ws.carnetDeVoyage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws.carnetDeVoyage.entity.Stage;
import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.service.TravelService;

@Controller
public class TravelController  {
	
	@Autowired
	private TravelService travelService;
	
	//EndPoints sur la liste des voyages
	@GetMapping("/travels")
	public String getAllTravel(Model model) {
		model.addAttribute("travels",travelService.getAll());
	 	return "travels";
	}

	@GetMapping("/travels/{travelId}/stages")
	public String gelAllStagesByTravelId(Model model, @PathVariable (required=false) Long travelId) {
		List<Stage> stages = new ArrayList<>();
		if (travelId != null) {
			Optional<Travel> optionalTravel = travelService.getById(travelId);
			if(optionalTravel.isPresent()) {
				stages = optionalTravel.get().getStages();
			}
		}
		model.addAttribute("stages",stages);
		return "stages";
	}

}