package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tipo_documento database table.
 * 
 */
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo_documento")
	private Integer codTipoDocumento;

	private String descripcion;

	public TipoDocumento() {
	}
	
	

	public TipoDocumento(Integer codTipoDocumento) {
		super();
		this.codTipoDocumento = codTipoDocumento;
	}



	public Integer getCodTipoDocumento() {
		return this.codTipoDocumento;
	}

	public void setCodTipoDocumento(Integer codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}