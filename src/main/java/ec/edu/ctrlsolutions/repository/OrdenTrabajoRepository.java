package ec.edu.ctrlsolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;

public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Integer> {
	
	@Query("SELECT distinct o FROM OrdenTrabajo o, OrdenTrabajoDetalle d WHERE o.codOrdenTrabajo=d.ordenTrabajo AND d.usuario = ?1")
	List<OrdenTrabajo> findOrdenTrabajoByUsuario(Usuario usuario) throws Exception;	
	
	@Query("SELECT o FROM OrdenTrabajo o WHERE o.codOrdenTrabajo.codOrdenTrabajo = ?1")
	OrdenTrabajo findOrdenTrabajoById(Integer codOrdenTrabajo) throws Exception;	

}
