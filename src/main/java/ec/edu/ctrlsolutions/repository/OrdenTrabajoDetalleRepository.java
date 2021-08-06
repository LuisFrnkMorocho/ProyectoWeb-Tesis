package ec.edu.ctrlsolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;

public interface OrdenTrabajoDetalleRepository extends JpaRepository<OrdenTrabajoDetalle, Integer> {
	
	@Query("SELECT COUNT(o) FROM OrdenTrabajoDetalle o WHERE o.ordenTrabajo =:ordenTrabajo AND o.estado in :listEstado")	
	 Integer existeOrdenNoFinalizadoRevision(@Param("ordenTrabajo") OrdenTrabajo  ordenTrabajo, @Param("listEstado") List<String> listEstado);

}
