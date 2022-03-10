package org.ssirbu.pap2021.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.pap2021.entities.Pais;
import org.ssirbu.pap2021.repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	PaisRepository paisRepository;
	
	public List<Pais> findAll(){
		return paisRepository.findAll();
		
	}
	
	public Pais save(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public Pais update(Pais pais) {
		Pais p  = paisRepository.getById(pais.getId());
		p.setNombre(pais.getNombre());
		paisRepository.saveAndFlush(p);
		return pais;
	}
	
	public void delete (Long id) {
		paisRepository.deleteById(id);
	}
	
	public Pais getPaisById(Long id) {
		return paisRepository.getById(id);
	}

}
