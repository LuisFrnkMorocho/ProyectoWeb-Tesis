package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;

public interface EquipoService {
	
	List<Equipo> findAll();

	List<Equipo> findEquipoByUserLoguedo(Usuario usuario, OrdenTrabajo ordenTrabajo) throws Exception;
	
	void save(Equipo equipo);

	void delete(Equipo equipo);
	
	List<Equipo> findEquipoByUserAdmin(OrdenTrabajo ordenTrabajo) throws Exception;
	

}
