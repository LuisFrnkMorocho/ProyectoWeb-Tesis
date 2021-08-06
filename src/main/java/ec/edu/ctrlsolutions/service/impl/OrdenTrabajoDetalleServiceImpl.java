package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;
import ec.edu.ctrlsolutions.repository.OrdenTrabajoDetalleRepository;
import ec.edu.ctrlsolutions.service.EquipoService;
import ec.edu.ctrlsolutions.service.OrdenTrabajoDetalleService;

@Service
public class OrdenTrabajoDetalleServiceImpl implements OrdenTrabajoDetalleService {

	@Autowired
	private OrdenTrabajoDetalleRepository ordenTrabajoDetalleRepository;
	
	@Autowired
	private EquipoService equipoService;
	 
	@Override
	public List<OrdenTrabajoDetalle> findAll(){
		return ordenTrabajoDetalleRepository.findAll();
	}

	@Override
	public void save(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		ordenTrabajoDetalleRepository.save(ordenTrabajoDetalle);
		
	}

	@Override
	public void delete(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		ordenTrabajoDetalleRepository.delete(ordenTrabajoDetalle);
		
	}

	@Override
	public void guardarOrdenDetallePorEquipo(OrdenTrabajoDetalle ordenTrabajoDetalle, Equipo equipo) throws Exception {
		ordenTrabajoDetalleRepository.save(ordenTrabajoDetalle);
		equipo.setOrdenTrabajoDetalle(ordenTrabajoDetalle);
		equipoService.save(equipo);		
	}

	@Override
	public Integer existeOrdenNoFinalizadoRevision(OrdenTrabajo ordenTrabajo, List<String> listEstado) throws Exception {
		return ordenTrabajoDetalleRepository.existeOrdenNoFinalizadoRevision(ordenTrabajo, listEstado);
	}

}
