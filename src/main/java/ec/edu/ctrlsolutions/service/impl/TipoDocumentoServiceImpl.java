package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.TipoDocumento;
import ec.edu.ctrlsolutions.repository.TipoDocumentoRepository;
import ec.edu.ctrlsolutions.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	 
	@Override
	public List<TipoDocumento> findAll(){
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public TipoDocumento findTipoDocumentoById(Integer id) {
		return tipoDocumentoRepository.findTipoDocumentoById(id);
	}

}
