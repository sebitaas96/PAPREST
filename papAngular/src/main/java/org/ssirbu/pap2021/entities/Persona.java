package org.ssirbu.pap2021.entities;



import java.time.LocalDate;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String nombre; 
	private LocalDate fNacimiento;
	private String password;
	//Es many to one por que muchas personas nacen en un pais y ya lo hemsos mapeado en pai
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Pais nace;
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	@ManyToOne
	private Pais vive;
	
	@ManyToMany
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Collection<Aficion>aficionesGusta;
	@ManyToMany
	@JsonIgnoreProperties({"hibernateLazyInitializer " , "handler"})
	private Collection<Aficion>aficionesDisgusta;
	
	
	//============================	
	public Persona() {
		this.nombre = "Jhon Doe";
		this.aficionesGusta = new ArrayList<Aficion>();
		this.aficionesDisgusta = new ArrayList<Aficion>();
		this.setfNacimiento(LocalDate.now());
	}

	public Persona(String nombre , String password , Pais nace ,Pais vive,LocalDate fNacimiento ) {
		this.nombre = nombre;
		this.aficionesGusta = new ArrayList<Aficion>();
		this.aficionesDisgusta = new ArrayList<Aficion>();
		this.password= encriptar(password);
		this.nace = nace;
		this.nace.getNativos().add(this);
		this.vive = vive;
		this.vive.getResidentes().add(this);
		this.setfNacimiento(fNacimiento);
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
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encriptar(password);
	}
	
	public Pais getNace() {
		return nace;
	}

	public void setNace(Pais nace) {
		this.nace = nace;
		this.nace.getNativos().add(this);
	}
	
	
	public Pais getVive() {
		return vive;
	}

	public void setVive(Pais vive) {
		this.vive = vive;
		this.vive.getResidentes().add(this);
	}

	public LocalDate getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}


	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}

	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		this.aficionesGusta = aficionesGusta;
	}
	public Collection<Aficion> getAficionesDisgusta() {
		return aficionesDisgusta;
	}

	public void setAficionesDisgusta(Collection<Aficion> aficionesDisgusta) {
		this.aficionesDisgusta = aficionesDisgusta;
	}
	
	
	//=============================

	
	public void addAficionGusta(Aficion aficion) {
		this.aficionesGusta.add(aficion);
		aficion.getPersonasGustan().add(this);
	}
	
	public void addAficionDisgusta(Aficion aficion) {
		this.aficionesDisgusta.add(aficion);
		aficion.getPersonasDisgustan().add(this);
	}


	private String encriptar(String password) {
		return (new BCryptPasswordEncoder()).encode(password);
	}
	
	public Integer getEdad() {
		int sol =0;
		LocalDate hoy = LocalDate.now();
		LocalDate fNac = this.getfNacimiento();
		if(fNac !=null) {
			Period intervalo = Period.between(fNac, hoy);
			sol = intervalo.getYears();
		}
		return sol;
	}
	
	public String getRol() {
		return nombre.equals("admin")?"admin":"auth";
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fNacimiento=" + fNacimiento + ", password=" + password
				+ ", nace=" + nace + ", vive=" + vive + ", aficionesGusta=" + aficionesGusta + ", aficionesDisgusta="
				+ aficionesDisgusta + "]";
	}
	
	




	
}
