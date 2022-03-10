package org.ssirbu.pap2021.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.pap2021.entities.Aficion;
import org.ssirbu.pap2021.repository.AficionRepository;

@Service
public class AficionService {
		
	@Autowired
	AficionRepository aficionRepository;
	
	public List<Aficion> findAll(){
		return aficionRepository.findAll();
	}
	
	public Aficion save(Aficion aficion) {
		return aficionRepository.save(aficion);
	}
	
	public Aficion update(Aficion aficion) {
		Aficion a  = aficionRepository.getById(aficion.getId());
		a.setNombre(aficion.getNombre());
		aficionRepository.saveAndFlush(a);
		return aficion;
	}
	
	public void delete (Long id) {
		aficionRepository.deleteById(id);
	}
	
	
}
