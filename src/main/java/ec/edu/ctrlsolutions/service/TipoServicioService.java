package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.TipoServicio;

public interface TipoServicioService {
	
	List<TipoServicio> findAll();

	void save(TipoServicio tipoServicio);

	void delete(TipoServicio tipoServicio);

}
