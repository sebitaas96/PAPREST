package org.ssirbu.notasClase2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.entities.Profesor;
import org.ssirbu.notasClase2022.repository.AsignaturaRepository;
import org.ssirbu.notasClase2022.repository.ProfesorRepository;

@Service
public class ProfesorService {
	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	public void crearProfesor(String dni ,String nombre ,String apellido ,String pwd ,List<Long> asigImaprte) throws Exception {
		try {
			Profesor p = new Profesor(dni , nombre,apellido,pwd);
			if(asigImaprte !=null) {
				for(Long id : asigImaprte) {
					Asignatura a = asignaturaRepository.getById(id);
					if(a.getProfesorImparte()==null) {
						p.addAsignaturaImparte(a);
					}
					else {
						throw new Exception("La asignatura ya la imparte otro profesor");
					}
				}
			}

			profesorRepository.save(p);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}
}
