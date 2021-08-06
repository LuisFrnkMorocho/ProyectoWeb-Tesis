package ec.edu.ctrlsolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.edu.ctrlsolutions.model.Diagnostico;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;
import ec.edu.ctrlsolutions.model.ReporteDTO;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

	@Query("SELECT d FROM Diagnostico d WHERE d.ordenTrabajoDetalle = ?1")
	Diagnostico findDiagnosticoByOrdenDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle);

	@Query(value = " SELECT t5.nombre || ' ' || t5.apellido cliente, "
			+ " t6.caracteristica, "
			+ " t6.marca, "
			+ " t6.modelo, "
			+ " t6.serial, "
			+ " t8.nombre || ' ' || t8.apellido tecnico, "
			+ " t1.observacion mantenimiento,"
			+ " t1.detalle_averia diagnostico,"
			+ " t1.detalle_reemplazo solucion, "
			+ " t3.fecha_registro fechaRegistro, "
			+ " t2.fecha_entrega fechaEntrega "
			+ " FROM diagnostico t1 INNER JOIN orden_trabajo_detalle t2 ON t1.cod_orden_trabajo_detalle=t2.cod_orden_trabajo_detalle "
			+ " INNER JOIN orden_trabajo t3 ON t2.cod_orden_trabajo=t3.cod_orden_trabajo "
			+ " INNER JOIN cliente t4 ON t3.cod_cliente=t4.cod_cliente "
			+ " INNER JOIN persona t5 ON t4.cod_persona=t5.cod_persona "
			+ " INNER JOIN equipo t6 ON t2.cod_orden_trabajo_detalle=t6.cod_orden_trabajo_detalle "
			+ " INNER JOIN usuario t7 ON t2.cod_usuario = t7.cod_usuario "
			+ " INNER JOIN persona t8 ON t7.cod_persona=t8.cod_persona "
			+ " WHERE t2.cod_orden_trabajo_detalle=:codOrdenTrabajoDetalle "
			+ " ORDER BY t2.cod_orden_trabajo_detalle " , nativeQuery = true)
	List<ReporteDTO> findByOrdenDetalleTrabajo(@Param("codOrdenTrabajoDetalle") Integer codOrdenTrabajoDetalle);

}
