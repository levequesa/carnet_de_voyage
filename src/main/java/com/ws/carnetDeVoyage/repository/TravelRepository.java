package com.ws.carnetDeVoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.carnetDeVoyage.entity.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
	
}