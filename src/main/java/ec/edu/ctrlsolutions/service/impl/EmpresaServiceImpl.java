package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Empresa;
import ec.edu.ctrlsolutions.repository.EmpresaRepository;
import ec.edu.ctrlsolutions.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	 
	@Override
	public List<Empresa> findAll(){
		return empresaRepository.findAll();
	}

	@Override
	public void save(Empresa empresa) {
		empresaRepository.save(empresa);
		
	}

	@Override
	public void delete(Empresa empresa) {
		empresaRepository.delete(empresa);
		
	}

}
