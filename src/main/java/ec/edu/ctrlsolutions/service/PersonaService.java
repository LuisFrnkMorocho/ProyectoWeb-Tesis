package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Persona;

public interface PersonaService {
	
	List<Persona> findAll();
	void save(Persona persona);
	void delete(Persona persona);
	Persona findPersonaByIdentificacion(String identificacion);

}
