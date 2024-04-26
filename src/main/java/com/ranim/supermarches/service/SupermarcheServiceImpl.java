package com.ranim.supermarches.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.Type;
import com.ranim.supermarches.repos.SupermarcheRepository;

@Service
public class SupermarcheServiceImpl implements SupermarcheService {
	
	@Autowired
	SupermarcheRepository supermarcheRepository;

	@Override
	public Supermarche saveSupermarche(Supermarche s) {
		return supermarcheRepository.save(s);
	}

	@Override
	public Supermarche updateSupermarche(Supermarche s) {
		return supermarcheRepository.save(s);
	}

	@Override
	public void deleteSupermarche(Supermarche s) {
		supermarcheRepository.delete(s);
		
	}

	@Override
	public void deleteSupermarcheById(Long id) {
		supermarcheRepository.deleteById(id);
		
	}

	@Override
	public Supermarche getSupermarche(Long id) {
		return supermarcheRepository.findById(id).get();
	}

	@Override
	public List<Supermarche> getAllSupermarches() {
		return supermarcheRepository.findAll();
	}

	@Override
	public Page<Supermarche> getAllSupermarchesParPage(int page, int size) {
		return supermarcheRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Supermarche> findByNomSupermarche(String nom) {
		return supermarcheRepository.findByNomSupermarche(nom);
	}

	@Override
	public List<Supermarche> findByNomSupermarcheContains(String nom) {
		return supermarcheRepository.findByNomSupermarcheContains(nom);
	}

	@Override
	public List<Supermarche> findByNomPrix(String nom, Double prix) {
		return supermarcheRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Supermarche> findByType(Type type) {
		return supermarcheRepository.findByType(type);
	}

	@Override
	public List<Supermarche> findByTypeIdType(Long id) {
		return supermarcheRepository.findByTypeIdType(id);
	}

	@Override
	public List<Supermarche> findByOrderByNomSupermarcheAsc() {
		return supermarcheRepository.findByOrderByNomSupermarcheAsc();
	}

	@Override
	public List<Supermarche> trierSupermarchesNomsPrix() {
		return supermarcheRepository.trierSupermarchesNomsPrix();
	}

}
