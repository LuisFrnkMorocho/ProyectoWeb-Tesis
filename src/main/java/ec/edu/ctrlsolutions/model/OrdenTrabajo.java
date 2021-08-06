package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the orden_trabajo database table.
 * 
 */
@Entity
@Table(name="orden_trabajo")
@NamedQuery(name="OrdenTrabajo.findAll", query="SELECT o FROM OrdenTrabajo o")
public class OrdenTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_orden_trabajo")
	private Integer codOrdenTrabajo;

	private String estado;


	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaRegistro;

	private String observacion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to OrdenTrabajoDetalle
	@OneToMany(mappedBy="ordenTrabajo")
	private List<OrdenTrabajoDetalle> ordenTrabajoDetalles;

	public OrdenTrabajo() {
	}
	
	

	public OrdenTrabajo(Integer codOrdenTrabajo) {
		super();
		this.codOrdenTrabajo = codOrdenTrabajo;
	}



	public Integer getCodOrdenTrabajo() {
		return this.codOrdenTrabajo;
	}

	public void setCodOrdenTrabajo(Integer codOrdenTrabajo) {
		this.codOrdenTrabajo = codOrdenTrabajo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}



	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdenTrabajoDetalle> getOrdenTrabajoDetalles() {
		return this.ordenTrabajoDetalles;
	}

	public void setOrdenTrabajoDetalles(List<OrdenTrabajoDetalle> ordenTrabajoDetalles) {
		this.ordenTrabajoDetalles = ordenTrabajoDetalles;
	}

	public OrdenTrabajoDetalle addOrdenTrabajoDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		getOrdenTrabajoDetalles().add(ordenTrabajoDetalle);
		ordenTrabajoDetalle.setOrdenTrabajo(this);

		return ordenTrabajoDetalle;
	}

	public OrdenTrabajoDetalle removeOrdenTrabajoDetalle(OrdenTrabajoDetalle ordenTrabajoDetalle) {
		getOrdenTrabajoDetalles().remove(ordenTrabajoDetalle);
		ordenTrabajoDetalle.setOrdenTrabajo(null);

		return ordenTrabajoDetalle;
	}

}