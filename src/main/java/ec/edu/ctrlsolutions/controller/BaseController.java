package ec.edu.ctrlsolutions.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ctrlsolutions.model.Usuario;

@Named(value = "baseViewController")
@SessionScoped	
public class BaseController implements Serializable {
	private static final long serialVersionUID = 1L;

	// constructor
	public BaseController() {

	}

	public Usuario usuarioLogueado() {
		Usuario usuario = null;
		FacesContext context = FacesContext.getCurrentInstance();
		usuario = (Usuario) context.getExternalContext().getSessionMap().get("userLogin");
		return usuario;
	}

	public boolean isAdministrador() {
		return usuarioLogueado().getCodPerfil().getDescripcion().equals("ADMINISTRADOR");
	}
	
	public static void messageInfo(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
	}
	
	public static void messageError(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
	}
	
	public static void messageWarn(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, message));
	}
}
