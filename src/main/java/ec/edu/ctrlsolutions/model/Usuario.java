package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usuario")
	private Integer codUsuario;


	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_perfil")
	private Perfil codPerfil;

	private String password;

	private String username;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_persona")
	private Persona persona;

	public Usuario() {
	}
	
	

	public Usuario(Integer codUsuario) {		
		this.codUsuario = codUsuario;
	}



	public Integer getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	

	/**
	 * @return the codPerfil
	 */
	public Perfil getCodPerfil() {
		return codPerfil;
	}



	/**
	 * @param codPerfil the codPerfil to set
	 */
	public void setCodPerfil(Perfil codPerfil) {
		this.codPerfil = codPerfil;
	}



	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}