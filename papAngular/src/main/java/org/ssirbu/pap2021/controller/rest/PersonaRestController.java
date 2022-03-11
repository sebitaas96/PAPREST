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
import org.ssirbu.pap2021.entities.Persona;
import org.ssirbu.pap2021.service.PersonaService;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins="http://localhost:4200")
public class PersonaRestController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping
	public List<Persona> r(){
		List<Persona> personas = personaService.findAll();
		return personas;
	}
	
	@PostMapping
	public Persona c(
			@RequestBody Persona persona)  {
		Persona  p = null;
		try {
			System.out.println(persona);
			p = personaService.save(persona);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	@PutMapping
	public Persona u(
			@RequestBody Persona persona)  {
		try {
			persona = personaService.update(persona);
		} catch (Exception e) {
		}
		return persona;
	}
	
	@DeleteMapping
	public Persona d(
			@RequestParam("id") Long id
			) {
		
		try {
			personaService.delete(id);
		}
		catch (Exception e) {
			
		}
		return null;
	}

}
