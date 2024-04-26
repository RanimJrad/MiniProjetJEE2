package com.ranim.supermarches;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.Type;
import com.ranim.supermarches.repos.SupermarcheRepository;
import com.ranim.supermarches.service.SupermarcheService;

@SpringBootTest
class SupermarcheProjApplicationTests {

	@Autowired
	private SupermarcheRepository supermarcheRepository;
	
	@Autowired
	private SupermarcheService supermarcheService;

	@Test
	public void testCreateSupermarche() {
		Supermarche sup = new Supermarche("MG", 15000.0, new Date());
		supermarcheRepository.save(sup);
	}

	@Test
	public void testFindSupermarche() {
		Supermarche s = supermarcheRepository.findById(2L).get();
		System.out.println(s);
	}

	@Test
	public void testUpdateSupermarche() {
		Supermarche s = supermarcheRepository.findById(2L).get();
		s.setPrixSupermarche(20500.0);
		supermarcheRepository.save(s);
		System.out.println(s);
	}

	@Test
	public void testDeleteSupermarche() {
		supermarcheRepository.deleteById(4L);
		;
	}

	@Test
	public void testListerTousSupermarches() {
		List<Supermarche> supers = supermarcheRepository.findAll();
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindByNomSupermarcheContains() {
		Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(0, 2);
		System.out.println(supers.getSize());
		System.out.println(supers.getTotalElements());
		System.out.println(supers.getTotalPages());
		supers.getContent().forEach(s -> {
			System.out.println(s.toString());
		});
		/*
		 * ou bien for (Supermarche s : supers) { System.out.println(s); }
		 */
	}
	
	@Test
	public void testFindByNomSupermarche() {
		List<Supermarche> supers = supermarcheRepository.findByNomSupermarche("Monoprix");
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}

	@Test
	public void testfindByNomSupermarcheContains() {
		List<Supermarche> supers = supermarcheRepository.findByNomSupermarcheContains("Mono");
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByNomPrix() {
		List<Supermarche> supers = supermarcheRepository.findByNomPrix("Aziza", 1000.0);
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByType() {
		Type typ = new Type();
		typ.setIdType(1L);
		List<Supermarche> supers = supermarcheRepository.findByType(typ);
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}
	
	@Test
	public void findByTypeIdTyp() {
		List<Supermarche> supers = supermarcheRepository.findByTypeIdType(1L);
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByOrderByNomSupermarcheAsc() {
		List<Supermarche> supers = supermarcheRepository.findByOrderByNomSupermarcheAsc();
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}

	@Test
	public void testTrierSupermarchesNomsPrix() {
		List<Supermarche> supers = supermarcheRepository.trierSupermarchesNomsPrix();
		for (Supermarche s : supers) {
			System.out.println(s);
		}
	}

}
