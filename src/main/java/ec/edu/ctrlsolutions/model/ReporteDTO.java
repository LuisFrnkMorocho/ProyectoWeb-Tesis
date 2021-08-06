package ec.edu.ctrlsolutions.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public interface ReporteDTO {
	String getCliente();

	String getCaracteristica();

	String getMarca();

	String getModelo();

	String getSerial();

	String getTecnico();

	String getMantenimiento();

	String getDiagnostico();

	String getsolucion();

	@Temporal(TemporalType.TIMESTAMP)
	Date getFechaRegistro();

	@Temporal(TemporalType.TIMESTAMP)
	Date getFechaEntrega();
}
