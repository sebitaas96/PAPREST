package org.ssirbu.pap2021.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.pap2021.entities.Persona;
import org.ssirbu.pap2021.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	public List<Persona> findAll(){
		return personaRepository.findAll();
		
	}
	
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	public Persona update(Persona persona) {
		Persona p  = personaRepository.getById(persona.getId());
		p.setNombre(persona.getNombre());
		personaRepository.saveAndFlush(p);
		return persona;
	}
	
	public void delete (Long id) {
		personaRepository.deleteById(id);
	}

	
}
