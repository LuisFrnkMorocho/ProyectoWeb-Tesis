package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;

public interface OrdenTrabajoDetalleService {
	
	List<OrdenTrabajoDetalle> findAll();

	void save(OrdenTrabajoDetalle ordenTrabajoDetalle);

	void delete(OrdenTrabajoDetalle ordenTrabajoDetalle);
	void guardarOrdenDetallePorEquipo(OrdenTrabajoDetalle ordenTrabajoDetalle, Equipo equipo) throws Exception;
	
	Integer existeOrdenNoFinalizadoRevision (OrdenTrabajo ordenTrabajo, List<String> listEstado) throws Exception;

}
