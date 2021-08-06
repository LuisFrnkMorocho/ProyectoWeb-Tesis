package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Diagnostico;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;
import ec.edu.ctrlsolutions.model.ReporteDTO;

public interface DiagnosticoService {
	
	List<Diagnostico> findAll();
	
	void save(Diagnostico diagnostico);

	void delete(Diagnostico diagnostico);

	Diagnostico findDiagnosticoByOrdenDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle) throws Exception;
	
	List<ReporteDTO> findByOrdenDetalleTrabajo(Integer codOrdenTrabajoDetalle);	

}
