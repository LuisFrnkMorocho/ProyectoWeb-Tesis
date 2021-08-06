package ec.edu.ctrlsolutions.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.repository.OrdenTrabajoRepository;
import ec.edu.ctrlsolutions.service.ClienteService;
import ec.edu.ctrlsolutions.service.OrdenTrabajoService;
import ec.edu.ctrlsolutions.service.PersonaService;

@Service
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {
	
	private final static Logger LOGGER = Logger.getLogger(OrdenTrabajoServiceImpl.class.getName());

	@Autowired
	private OrdenTrabajoRepository ordenTrabajoRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ClienteService clienteService;
	 
	@Override
	public List<OrdenTrabajo> findAll(){
		return ordenTrabajoRepository.findAll();
	}

	@Override
	public void save(OrdenTrabajo ordenTrabajo) {
		ordenTrabajoRepository.save(ordenTrabajo);
		
	}

	@Override
	public void delete(OrdenTrabajo ordenTrabajo) {
		ordenTrabajoRepository.delete(ordenTrabajo);
		
	}

	@Override
	public void guardarOrdenTrabajoPorCliente(OrdenTrabajo ordenTrabajo) throws Exception {
		try {
			personaService.save(ordenTrabajo.getCliente().getPersona());
			clienteService.save(ordenTrabajo.getCliente());
			ordenTrabajo.setFechaRegistro(new Date());
			ordenTrabajo.setEstado("INGRESADO");
			ordenTrabajo.setCliente(ordenTrabajo.getCliente());
			ordenTrabajoRepository.save(ordenTrabajo);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
		}
		
		
	}

	@Override
	public OrdenTrabajo findById(Integer id) {		
		return ordenTrabajoRepository.getById(id);
	}

	@Override
	public List<OrdenTrabajo> findOrdenTrabajoByUsuario(Usuario usuario) throws Exception {
		return ordenTrabajoRepository.findOrdenTrabajoByUsuario(usuario);
	}

	@Override
	public OrdenTrabajo findOrdenTrabajoById(Integer codOrdenTrabajo) throws Exception {
		// TODO Auto-generated method stub
		return ordenTrabajoRepository.findOrdenTrabajoById(codOrdenTrabajo);
	}

}
