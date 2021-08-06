package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.TipoServicio;
import ec.edu.ctrlsolutions.repository.TipoServicioRepository;
import ec.edu.ctrlsolutions.service.TipoServicioService;

@Service
public class TipoServicioServiceImpl implements TipoServicioService {

	@Autowired
	private TipoServicioRepository tipoServicioRepository;
	 
	@Override
	public List<TipoServicio> findAll(){
		return tipoServicioRepository.findAll();
	}

	@Override
	public void save(TipoServicio tipoServicio) {
		tipoServicioRepository.save(tipoServicio);
		
	}

	@Override
	public void delete(TipoServicio tipoServicio) {
		tipoServicioRepository.delete(tipoServicio);
		
	}

}
