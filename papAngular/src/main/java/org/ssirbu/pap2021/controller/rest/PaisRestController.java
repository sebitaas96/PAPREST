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
import org.ssirbu.pap2021.entities.Pais;
import org.ssirbu.pap2021.service.PaisService;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisRestController {
	@Autowired
	private PaisService paisService;

	@GetMapping
	public List<Pais> r() {
		List<Pais> paises = paisService.findAll();
		return paises;
	}
	
	@PostMapping
	public Pais c(
			@RequestBody Pais pais)  {
		Pais p = null;
		try {
			p = paisService.save(pais);
		} catch (Exception e) {
		}
		return p;
	}
	
	@PutMapping
	public Pais u(
			@RequestBody Pais pais)  {
		try {
			pais = paisService.update(pais);
		} catch (Exception e) {
		}
		return pais;
	}
	
	@DeleteMapping
	public Pais d(
			@RequestParam("id") Long id
			) {
		
		try {
			paisService.delete(id);
		}
		catch (Exception e) {
			
		}
		return null;
	}
	
	
}