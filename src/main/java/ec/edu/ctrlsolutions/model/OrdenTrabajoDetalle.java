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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the orden_trabajo_detalle database table.
 * 
 */
@Entity
@Table(name="orden_trabajo_detalle")
@NamedQuery(name="OrdenTrabajoDetalle.findAll", query="SELECT o FROM OrdenTrabajoDetalle o")
public class OrdenTrabajoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_orden_trabajo_detalle")
	private Integer codOrdenTrabajoDetalle;

	private String estado;
	
	@Column(name="motivo_mantenimiento")
	private String motivoMantenimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	//bi-directional many-to-one association to OrdenTrabajo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_orden_trabajo")
	private OrdenTrabajo ordenTrabajo;

	//bi-directional many-to-one association to TipoServicio
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_tipo_servicio")
	private TipoServicio tipoServicio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;

	public OrdenTrabajoDetalle() {
	}

	public Integer getCodOrdenTrabajoDetalle() {
		return this.codOrdenTrabajoDetalle;
	}

	public void setCodOrdenTrabajoDetalle(Integer codOrdenTrabajoDetalle) {
		this.codOrdenTrabajoDetalle = codOrdenTrabajoDetalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return this.ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the motivoMantenimiento
	 */
	public String getMotivoMantenimiento() {
		return motivoMantenimiento;
	}

	/**
	 * @param motivoMantenimiento the motivoMantenimiento to set
	 */
	public void setMotivoMantenimiento(String motivoMantenimiento) {
		this.motivoMantenimiento = motivoMantenimiento;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
	

}