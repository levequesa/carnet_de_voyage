package com.ws.carnetDeVoyage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.repository.TravelRepository;

@Service
public class TravelService {
	
    @Autowired
    private TravelRepository travelRepository;
    
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

	public void save(Travel travel) {
		travelRepository.save(travel);
	}

}
