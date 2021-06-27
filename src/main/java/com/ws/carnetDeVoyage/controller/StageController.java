package com.ws.carnetDeVoyage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ws.carnetDeVoyage.entity.Stage;
import com.ws.carnetDeVoyage.service.StageService;


@Controller
public class StageController  {
	
	@Autowired
	private StageService stageService;

	@GetMapping("/stages")
	public String getAllStageByTravel(Model model) {
		List<Stage> stages = stageService.getAllStage();
		model.addAttribute("stages",stages);
		return "stages";
	}
	
}