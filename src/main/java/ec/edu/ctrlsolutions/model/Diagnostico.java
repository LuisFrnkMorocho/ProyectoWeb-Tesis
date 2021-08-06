package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the diagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnostico.findAll", query="SELECT d FROM Diagnostico d")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_diagnostico")
	private Integer codDiagnostico;

	@Column(name="detalle_averia")
	private String detalleAveria;
	
	@Column(name="observacion")
	private String observacion;

	@Column(name="detalle_reemplazo")
	private String detalleReemplazo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_diagnostico")
	private Date fechaDiagnostico;
	//bi-directional many-to-one association to OrdenTrabajoDetalle
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_orden_trabajo_detalle")
	private OrdenTrabajoDetalle ordenTrabajoDetalle;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;

	public Diagnostico() {
	}

	public Integer getCodDiagnostico() {
		return this.codDiagnostico;
	}

	public void setCodDiagnostico(Integer codDiagnostico) {
		this.codDiagnostico = codDiagnostico;
	}

	public String getDetalleAveria() {
		return this.detalleAveria;
	}

	public void setDetalleAveria(String detalleAveria) {
		this.detalleAveria = detalleAveria;
	}

	public String getDetalleReemplazo() {
		return this.detalleReemplazo;
	}

	public void setDetalleReemplazo(String detalleReemplazo) {
		this.detalleReemplazo = detalleReemplazo;
	}

	

	/**
	 * @return the fechaDiagnostico
	 */
	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}

	/**
	 * @param fechaDiagnostico the fechaDiagnostico to set
	 */
	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}

	public OrdenTrabajoDetalle getOrdenTrabajoDetalle() {
		return this.ordenTrabajoDetalle;
	}

	public void setOrdenTrabajoDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		this.ordenTrabajoDetalle = ordenTrabajoDetalle;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
}