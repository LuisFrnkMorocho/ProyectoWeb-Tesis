package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.ctrlsolutions.model.Persona;

import ec.edu.ctrlsolutions.repository.PersonaRepository;
import ec.edu.ctrlsolutions.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	 
	@Override
	public List<Persona> findAll(){
		return personaRepository.findAll();
	}

	@Override
	public void save(Persona persona) {
		personaRepository.save(persona);
		
	}

	@Override
	public void delete(Persona persona) {
		personaRepository.delete(persona);
		
	}

	@Override
	public Persona findPersonaByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		return personaRepository.findPersonaByIdentificacion(identificacion);
	}

}
