package org.ssirbu.pap2021.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ssirbu.pap2021.entities.Aficion;
import org.ssirbu.pap2021.service.AficionService;

@RestController
@RequestMapping("/aficion")
@CrossOrigin(origins="http://localhost:4200")
public class AficionRestController {
	
	@Autowired
	AficionService aficionService;
	
	@GetMapping
	public List<Aficion> r(){
		List<Aficion> aficiones = aficionService.findAll();
		return aficiones;
	}
	
	@PostMapping
	public Aficion c(
			@RequestBody Aficion aficion)  {
		Aficion a = null;
		try {
			a = aficionService.save(aficion);
		} catch (Exception e) {
		}
		return a;
	}
	
	@PutMapping
	public Aficion u(
			@RequestBody Aficion aficion)  {
		try {
			aficion = aficionService.update(aficion);
		} catch (Exception e) {
		}
		return aficion;
	}
	
	@DeleteMapping
	public Aficion d(
			@RequestParam("id") Long id
			) {
		
		try {
			aficionService.delete(id);
		}
		catch (Exception e) {
			
		}
		return null;
	}
	
	
}
