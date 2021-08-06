package ec.edu.ctrlsolutions.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Persona;
import ec.edu.ctrlsolutions.service.PersonaService;

@Named(value = "personaViewController")
@ViewScoped
public class PersonaViewController {
	@Autowired
	private PersonaService personaService;
	List<Persona> listPersona;

	public PersonaViewController() {
		super();
	}

	/**
	 * @return the listPersona
	 */
	public List<Persona> getListPersona() {
		return listPersona;
	}

	/**
	 * @param listPersona the listPersona to set
	 */
	public void setListPersona(List<Persona> listPersona) {
		this.listPersona = listPersona;
	}

	@PostConstruct
	public void doInit() {
		listPersona = listPersonaAll();
	}

	public List<Persona> listPersonaAll() {

		return personaService.findAll();
	}
}
