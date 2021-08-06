package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c WHERE c.persona.identificacion =:identificacion AND c.persona.tipoDocumento.descripcion =: descripcion")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cliente")
	private Integer codCliente;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_persona")
	private Persona persona;

	//bi-directional many-to-one association to OrdenTrabajo
	@OneToMany(mappedBy="cliente")
	private List<OrdenTrabajo> ordenTrabajos;

	public Cliente() {
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<OrdenTrabajo> getOrdenTrabajos() {
		return this.ordenTrabajos;
	}

	public void setOrdenTrabajos(List<OrdenTrabajo> ordenTrabajos) {
		this.ordenTrabajos = ordenTrabajos;
	}

	public OrdenTrabajo addOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		getOrdenTrabajos().add(ordenTrabajo);
		ordenTrabajo.setCliente(this);

		return ordenTrabajo;
	}

	public OrdenTrabajo removeOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		getOrdenTrabajos().remove(ordenTrabajo);
		ordenTrabajo.setCliente(null);

		return ordenTrabajo;
	}

}