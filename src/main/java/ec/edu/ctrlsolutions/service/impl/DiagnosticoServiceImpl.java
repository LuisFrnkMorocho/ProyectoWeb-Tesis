package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Diagnostico;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;
import ec.edu.ctrlsolutions.model.ReporteDTO;
import ec.edu.ctrlsolutions.repository.DiagnosticoRepository;
import ec.edu.ctrlsolutions.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

	@Autowired
	private DiagnosticoRepository diagnosticoRepository;
	 
	@Override
	public List<Diagnostico> findAll(){
		return diagnosticoRepository.findAll();
	}

	@Override
	public void save(Diagnostico diagnostico) {
		diagnosticoRepository.save(diagnostico);
		
	}

	@Override
	public void delete(Diagnostico diagnostico) {
		diagnosticoRepository.delete(diagnostico);		
	}

	@Override
	public Diagnostico findDiagnosticoByOrdenDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle) throws Exception {
		return diagnosticoRepository.findDiagnosticoByOrdenDetalle(ordenTrabajoDetalle);
	}

	@Override
	public List<ReporteDTO> findByOrdenDetalleTrabajo(Integer codOrdenTrabajoDetalle) {
		return diagnosticoRepository.findByOrdenDetalleTrabajo(codOrdenTrabajoDetalle);
	}

}
