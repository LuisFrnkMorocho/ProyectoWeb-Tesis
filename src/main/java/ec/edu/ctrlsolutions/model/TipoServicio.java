package ec.edu.ctrlsolutions.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_servicio database table.
 * 
 */
@Entity
@Table(name="tipo_servicio")
@NamedQuery(name="TipoServicio.findAll", query="SELECT t FROM TipoServicio t")
public class TipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_servicio")
	private Integer codTipoServicio;

	private String descripcion;


	public TipoServicio() {
	}

	
	public TipoServicio(Integer codTipoServicio) {
		this.codTipoServicio = codTipoServicio;
	}


	public Integer getCodTipoServicio() {
		return this.codTipoServicio;
	}

	public void setCodTipoServicio(Integer codTipoServicio) {
		this.codTipoServicio = codTipoServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}