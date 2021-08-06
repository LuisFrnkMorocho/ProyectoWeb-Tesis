package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.TipoDocumento;

public interface TipoDocumentoService {
	
	List<TipoDocumento> findAll();
	TipoDocumento findTipoDocumentoById(Integer id);

}
