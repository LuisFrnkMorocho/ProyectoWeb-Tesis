package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Cliente;
import ec.edu.ctrlsolutions.repository.ClienteRepository;
import ec.edu.ctrlsolutions.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	 
	@Override
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);		
	}

}
