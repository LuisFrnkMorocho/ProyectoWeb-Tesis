package ec.edu.ctrlsolutions.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Menu;
import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.service.MenuService;

@Named(value = "homeViewController")
@SessionScoped	
public class HomeViewController extends BaseController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getLogger(HomeViewController.class.getName());
	private boolean esAdministrador;
	private Usuario usuario;
	@Autowired
	private MenuService menuService;
	private List<Menu> listMenu;
	private MenuModel menuModel;

	// constructor
	public HomeViewController() {

	}

	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void verificarUsuario() {
		try {
			usuario = usuarioLogueado();
			if (usuario != null) {				
				//esAdministrador = this.perfilUsuario(usuario);
			} else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("accessDenied.jsf");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void generarMenu() {
		try {
			usuario = usuarioLogueado();
			if (usuario != null) {
				generarMenuPorUsuarioAutentificado();
			}
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the listMenu
	 */
	public List<Menu> getListMenu() {
		return listMenu;
	}

	/**
	 * @param listMenu the listMenu to set
	 */
	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
	}

	/**
	 * @return the menuModel
	 */
	public MenuModel getMenuModel() {
		return menuModel;
	}

	/**
	 * @param menuModel the menuModel to set
	 */
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
		
	public void generarMenuPorUsuarioAutentificado() {
		listMenu = menuService.findAll();
		menuModel = new DefaultMenuModel();
		if (listMenu != null && !listMenu.isEmpty() && usuario!=null) {
			for (Menu menu : listMenu) {
				if (menu.getTipoMenu().equals("S") && menu.getPerfil().getCodPerfil().equals(usuario.getCodPerfil().getCodPerfil())) {
					DefaultSubMenu firstSubmenu  = DefaultSubMenu.builder().label(menu.getDescripcion()).build();
					for (Menu menuItem : listMenu) {
						Menu submenu = menuItem.getSubMenu();
						if (submenu != null) {
							if (submenu.getCodMenu() == menu.getCodMenu()) {
								DefaultMenuItem item = DefaultMenuItem.builder().value(menuItem.getDescripcion()).build();
								item.setUrl(menuItem.getUrl());
								firstSubmenu.getElements().add(item);
							}
						}
					}
					menuModel.getElements().add(firstSubmenu);
				} else {
					if (menu.getSubMenu() == null && menu.getPerfil().getCodPerfil().equals(usuario.getCodPerfil().getCodPerfil())) {
						DefaultMenuItem item = DefaultMenuItem.builder().value(menu.getDescripcion()).build();								
						item.setUrl(menu.getUrl());
						menuModel.getElements().add(item);
					}
				}
			}

		}

	}
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
