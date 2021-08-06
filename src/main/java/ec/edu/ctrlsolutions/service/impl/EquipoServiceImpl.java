package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.repository.EquipoRepository;
import ec.edu.ctrlsolutions.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepository equipoRepository;
	 
	@Override
	public List<Equipo> findAll(){
		return equipoRepository.findAll();
	}

	@Override
	public void save(Equipo equipo) {
		equipoRepository.save(equipo);
		
	}

	@Override
	public void delete(Equipo equipo) {
		equipoRepository.delete(equipo);
		
	}

	@Override
	public List<Equipo> findEquipoByUserLoguedo(Usuario usuario, OrdenTrabajo ordenTrabajo) throws Exception {
		return equipoRepository.findEquipoByUserLoguedo(usuario, ordenTrabajo);
	}

	@Override
	public List<Equipo> findEquipoByUserAdmin(OrdenTrabajo ordenTrabajo) throws Exception {
		// TODO Auto-generated method stub
		return equipoRepository.findEquipoByUserAdmin(ordenTrabajo);
	}

}
