package com.ranim.supermarches.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.service.SupermarcheService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SupermarcheRESTController {
	
	@Autowired
	SupermarcheService supermarcheService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Supermarche> getAllSupermarches() {
		return supermarcheService.getAllSupermarches();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Supermarche getSupermarcheById(@PathVariable("id") Long id) {
		return supermarcheService.getSupermarche(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Supermarche createSupermarche(@RequestBody Supermarche supermarche) {
		return supermarcheService.saveSupermarche(supermarche);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Supermarche updateSupermarche(@RequestBody Supermarche supermarche) {
		return supermarcheService.updateSupermarche(supermarche);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteSupermarche(@PathVariable("id") Long id)
	{
		supermarcheService.deleteSupermarcheById(id);
	}
	
	@RequestMapping(value = "/superstyp/{idType}", method = RequestMethod.GET)
	public List<Supermarche> getSupermarchesByTypeId(@PathVariable("idType") Long idType) {
		return supermarcheService.findByTypeIdType(idType);
	}

}
