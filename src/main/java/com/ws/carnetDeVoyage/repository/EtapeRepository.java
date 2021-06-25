package com.ws.carnetDeVoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.carnetDeVoyage.entity.Etape;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Long> {
	
}