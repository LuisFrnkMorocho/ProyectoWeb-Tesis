package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;

public interface OrdenTrabajoService {
	
	OrdenTrabajo findById(Integer id);
	
	List<OrdenTrabajo> findAll();

	void save(OrdenTrabajo ordenTrabajo);

	void delete(OrdenTrabajo ordenTrabajo);
	
	void guardarOrdenTrabajoPorCliente(OrdenTrabajo ordenTrabajo) throws Exception;
	
	List<OrdenTrabajo> findOrdenTrabajoByUsuario(Usuario usuario) throws Exception;
	
	OrdenTrabajo findOrdenTrabajoById(Integer codOrdenTrabajo) throws Exception;

}
