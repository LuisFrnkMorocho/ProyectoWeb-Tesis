package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Empresa;

public interface EmpresaService {
	
	List<Empresa> findAll();

	void save(Empresa empresa);

	void delete(Empresa empresa	);

}
