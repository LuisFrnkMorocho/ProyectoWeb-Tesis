package ec.edu.ctrlsolutions.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.service.UsuarioService;

@Named(value = "loginViewController")
@ViewScoped
public class LoginViewController {
	@Autowired
	private UsuarioService usuarioService;
	private String username;
	private String password;

	public LoginViewController() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String validacionUsuario() {
		String path = null;	
		try {
			Usuario inicioSesion = usuarioService.autentificarUsuario(username, password);
			if(inicioSesion != null)		{
				
				path ="pages/home?faces-redirect=true";
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogin", inicioSesion);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Bienvenido - Ingreso Ok"));
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Error en Inicio de Sesión"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error"));			
		}
		return path;
	}
}
