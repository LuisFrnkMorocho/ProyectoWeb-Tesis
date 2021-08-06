package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
	
	void save(Cliente cliente);

	void delete(Cliente cliente);
	

}
