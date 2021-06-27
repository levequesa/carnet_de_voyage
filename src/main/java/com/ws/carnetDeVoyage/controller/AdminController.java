package com.ws.carnetDeVoyage.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws.carnetDeVoyage.entity.Stage;
import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.repository.StageRepository;
import com.ws.carnetDeVoyage.service.StageService;
import com.ws.carnetDeVoyage.service.TravelService;

//EndPoints en tant que admin : consultation / creation / Maj / supp
@Controller
public class AdminController {
	
	@Autowired
	public TravelService travelService;
	@Autowired
	public StageService stageService;

	@GetMapping("/admin")
	public String getAdminPortail(Model model) {
		return "admin";
	}
	
	@GetMapping("/admin/travel")
	public String getTravelById(Model model,@RequestParam(required=false) Long id) {
		Travel travel = new Travel();
		if (id !=null) {
			Optional<Travel> optionalTravel = travelService.getById(id);
			if (optionalTravel.isPresent()) {
				travel = optionalTravel.get();
			}
		}
		model.addAttribute("travel", travel);
		return "travel";
	}
	
	@PostMapping("/admin/travel")
	public String addTravel(@ModelAttribute Travel travel) {
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String dfDeb = df.parse(travel.getDeb());
		travelService.save(travel);
		return "admin";
	}
	
	@GetMapping("/admin/stage")
	public String getStageById(Model model,@RequestParam(required=false) Long id) {
		Stage stage=new Stage();
		if (id!=null) {
			Optional<Stage> optionalStage = stageService.getById(id);
			if (optionalStage.isPresent()) {
				stage = optionalStage.get();
			}
		}
		List<Travel> travels = travelService.getAll();
		model.addAttribute("travels",travels);
		model.addAttribute("stage",stage);
		return "stage";
	}
	
	@PostMapping("/admin/stage")
	public String addStage(@ModelAttribute Stage stage) {
		stageService.save(stage);
		return null;
		
	}
}
