package com.ranim.supermarches.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.Type;

public interface SupermarcheService {
	
	Supermarche saveSupermarche(Supermarche s);
	Supermarche updateSupermarche(Supermarche s);
	void deleteSupermarche(Supermarche s);
	void deleteSupermarcheById(Long id);
	Supermarche getSupermarche(Long id);
	List<Supermarche> getAllSupermarches();
	Page<Supermarche> getAllSupermarchesParPage(int page, int size);
	List<Supermarche> findByNomSupermarche(String nom);
	List<Supermarche> findByNomSupermarcheContains(String nom);
	List<Supermarche> findByNomPrix (String nom, Double prix);
	List<Supermarche> findByType (Type type);
	List<Supermarche> findByTypeIdType(Long id);
	List<Supermarche> findByOrderByNomSupermarcheAsc();
	List<Supermarche> trierSupermarchesNomsPrix();

}
