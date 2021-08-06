package ec.edu.ctrlsolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.Usuario;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
	
	@Query("SELECT e FROM Equipo e WHERE e.ordenTrabajoDetalle.usuario = ?1 AND e.ordenTrabajoDetalle.ordenTrabajo = ?2")
	List<Equipo> findEquipoByUserLoguedo(Usuario usuario, OrdenTrabajo ordenTrabajo) throws Exception;
	
	@Query("SELECT e FROM Equipo e WHERE e.ordenTrabajoDetalle.ordenTrabajo = ?1")
	List<Equipo> findEquipoByUserAdmin(OrdenTrabajo ordenTrabajo) throws Exception;	

}
