package ec.edu.ctrlsolutions.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_menu")
	private Integer codMenu;


	private String descripcion;

	private String estado;

	@Column(name="tipo_menu")
	private String tipoMenu;
	
	@Column(name="url")
	private String url;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="cod_perfil")
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name="cod_menu_padre")
	private Menu subMenu;

	public Menu() {
	}

	public Integer getCodMenu() {
		return this.codMenu;
	}

	public void setCodMenu(Integer codMenu) {
		this.codMenu = codMenu;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoMenu() {
		return this.tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the subMenu
	 */
	public Menu getSubMenu() {
		return subMenu;
	}

	/**
	 * @param subMenu the subMenu to set
	 */
	public void setSubMenu(Menu subMenu) {
		this.subMenu = subMenu;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}