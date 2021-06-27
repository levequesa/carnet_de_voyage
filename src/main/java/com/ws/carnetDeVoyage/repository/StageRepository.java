package com.ws.carnetDeVoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.carnetDeVoyage.entity.Stage;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
	
}