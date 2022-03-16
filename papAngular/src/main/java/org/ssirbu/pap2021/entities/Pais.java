package org.ssirbu.pap2021.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true , nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="nace" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Persona> nativos;
	@OneToMany(mappedBy = "vive" , cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Persona>residentes;
	//============================	
	public Pais() {
		this.nombre = "Atlantida";
		this.nativos = new ArrayList<Persona>();
		this.residentes = new ArrayList<Persona>();
	}

	public Pais(String nombre) {
		this.nombre = nombre;
		this.nativos = new ArrayList<Persona>();
		this.residentes = new ArrayList<Persona>();
	}

	
	//=============================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Collection<Persona> getNativos() {
		return nativos;
	}

	public void setNativos(Collection<Persona> nativos) {
		this.nativos = nativos;
	}
	

	public Collection<Persona> getResidentes() {
		return residentes;
	}

	public void setResidentes(Collection<Persona> residentes) {
		this.residentes = residentes;
	}

	//=============================
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}
	
}
