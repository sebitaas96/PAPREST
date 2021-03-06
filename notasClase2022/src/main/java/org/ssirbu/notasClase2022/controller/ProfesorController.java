package org.ssirbu.notasClase2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.entities.Profesor;
import org.ssirbu.notasClase2022.exception.DangerException;
import org.ssirbu.notasClase2022.exception.InfoException;
import org.ssirbu.notasClase2022.exception.PRG;
import org.ssirbu.notasClase2022.service.AsignaturaService;
import org.ssirbu.notasClase2022.service.ProfesorService;



@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;
	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping("r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Profesor> profesores = profesorService.findAll();
		m.put("profesores", profesores);
		m.put("view","profesor/r");
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		List<Asignatura> asignaturas = asignaturaService.findAll();
		System.out.println(asignaturas);
		m.put("asignaturas", asignaturas);
		m.put("view", "profesor/c");
		return "_t/frame";
	}
	
	@PostMapping("cPost") 
	public void cPost(
			@RequestParam("dni") String dni,
			@RequestParam("nom") String nombre,
			@RequestParam("ape") String apellido,
			@RequestParam("pass") String pwd,
			@RequestParam(value="asigImparte[]" ,required=false)List<Long>asigImparte
			) throws DangerException, InfoException {
	
		try {
			profesorService.crearProfesor(dni ,nombre ,apellido , pwd , asigImparte);
		}
		catch(Exception e) {
			PRG.error("Ha habido un error añadiendo al profesor"+e.getMessage() ,"/profesor/c");
		}
		PRG.info("El profesor se ha insertado correctamente" ,"/profesor/r");
	}
}
