package com.ws.carnetDeVoyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.carnetDeVoyage.entity.Travel;
import com.ws.carnetDeVoyage.repository.TravelRepository;

@Service
public class TravelService {
	
    @Autowired
    private TravelRepository travelRepository;
    
    public List<Travel> getAll() {
        return travelRepository.findAll();
    }
	
    public Optional<Travel> getById(Long id) {
    	if (id !=null) {
    		Optional<Travel> optionalTravel = travelRepository.findById(id);
    		if (optionalTravel.isPresent()) {
    			return optionalTravel;
    		}
    	}
		return null;
    }
    
    public void save(Travel travel) {
		travelRepository.save(travel);
	}
	
    public void deleteById(Long id) {
    	if (id !=null ) {
    		travelRepository.deleteById(id);
    	}
    }

}
