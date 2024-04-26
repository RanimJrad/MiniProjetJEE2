package com.ranim.supermarches.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.service.SupermarcheService;

@Controller
public class SupermarcheController {

	@Autowired
	SupermarcheService supermarcheService;

	@RequestMapping("/ListeSupermarches")
	public String listeProduits(ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		
		Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(page, size);
		modelMap.addAttribute("supermarches", supers);
		modelMap.addAttribute("pages", new int[supers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSupermarches";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createSupermarche";
	}

	@RequestMapping("/saveSupermarche")
	public String saveSupermarche(@ModelAttribute("supermarche") Supermarche supermarche,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConstruction = dateformat.parse(String.valueOf(date));
		supermarche.setDateConstruction(dateConstruction);
		Supermarche saveSupermarche = supermarcheService.saveSupermarche(supermarche);
		String msg = "Supermarche enregistré avec Id " + saveSupermarche.getIdSupermarche();
		modelMap.addAttribute("msg", msg);
		return "createSupermarche";
	}

	@RequestMapping("/supprimerSupermarche")
	public String supprimerSupermarche(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		
		supermarcheService.deleteSupermarcheById(id);
		Page<Supermarche> supers = supermarcheService.getAllSupermarchesParPage(page, size);
		modelMap.addAttribute("supermarches", supers);
		modelMap.addAttribute("pages", new int[supers.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSupermarches";
	}

	@RequestMapping("/modifierSupermarche")
	public String editerSupermarche(@RequestParam("id") Long id, ModelMap modelMap) {
		Supermarche s = supermarcheService.getSupermarche(id);
		modelMap.addAttribute("supermarche", s);
		return "editerSupermarche";
	}

	@RequestMapping("/updateSupermarche")
	public String updateSupermarche(@ModelAttribute("supermarche") Supermarche supermarche,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateConstruction = dateformat.parse(String.valueOf(date));
		supermarche.setDateConstruction(dateConstruction);
		supermarcheService.updateSupermarche(supermarche);
		List<Supermarche> supers = supermarcheService.getAllSupermarches();
		modelMap.addAttribute("supermarche", supers);
		return "listeSupermarches";
	}

}
