package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Perfil;
import ec.edu.ctrlsolutions.repository.PerfilRepository;
import ec.edu.ctrlsolutions.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	 
	@Override
	public List<Perfil> findAll(){
		return perfilRepository.findAll();
	}

	

}
