package com.ws.carnetDeVoyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.carnetDeVoyage.entity.Stage;
import com.ws.carnetDeVoyage.repository.StageRepository;

@Service
public class StageService {

	@Autowired
	private StageRepository stageRepository;
	
	public void save(Stage stage) {
		stageRepository.save(stage);
	}
	
	public List<Stage> getAllStage(){
		return stageRepository.findAll();
	}
	
	public Optional<Stage> getById(Long id) {
		if (id != null ) {
			Optional<Stage> optionalStage = stageRepository.findById(id);
			if (optionalStage.isPresent()) {
				return optionalStage;
			}
		}
		return null;
	}

	public void deleteById(Long id) {
		if (id !=null) {
			Optional<Stage> optionalStage = stageRepository.findById(id);
			if (optionalStage.isPresent()) {
				stageRepository.deleteById(id);
			}
		}
	}
}
