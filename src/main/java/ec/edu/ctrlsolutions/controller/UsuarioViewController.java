package ec.edu.ctrlsolutions.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Perfil;
import ec.edu.ctrlsolutions.model.Persona;
import ec.edu.ctrlsolutions.model.TipoDocumento;
import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.service.PerfilService;
import ec.edu.ctrlsolutions.service.PersonaService;
import ec.edu.ctrlsolutions.service.TipoDocumentoService;
import ec.edu.ctrlsolutions.service.UsuarioService;

@Named(value = "usuarioViewController")
@ViewScoped
public class UsuarioViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(UsuarioViewController.class.getName());

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private PersonaService personaService;
	
	private List<Usuario> listUsuario;
	private List<TipoDocumento> listTipoDocumento;
	private List<Perfil> listPerfil;
	private Usuario usuario;
	public boolean pnlSearchOrViewData=false;
	public String accion="";
	public Integer idTipoDocumentoSelected;
	public Integer idPerfilSelected;
	public boolean showField=false;

	public UsuarioViewController() {
		super();
	}

	// getters and setters

	

	/**
	 * @return the pnlSearchOrViewData
	 */
	public boolean isPnlSearchOrViewData() {
		return pnlSearchOrViewData;
	}

	

	

	/**
	 * @return the listUsuario
	 */
	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	/**
	 * @param listUsuario the listUsuario to set
	 */
	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param pnlSearchOrViewData the pnlSearchOrViewData to set
	 */
	public void setPnlSearchOrViewData(boolean pnlSearchOrViewData) {
		this.pnlSearchOrViewData = pnlSearchOrViewData;
	}
	

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	

	/**
	 * @return the listTipoDocumento
	 */
	public List<TipoDocumento> getListTipoDocumento() {
		return listTipoDocumento;
	}

	/**
	 * @param listTipoDocumento the listTipoDocumento to set
	 */
	public void setListTipoDocumento(List<TipoDocumento> listTipoDocumento) {
		this.listTipoDocumento = listTipoDocumento;
	}

	
	
	/**
	 * @return the idTipoDocumentoSelected
	 */
	public Integer getIdTipoDocumentoSelected() {
		return idTipoDocumentoSelected;
	}

	/**
	 * @param idTipoDocumentoSelected the idTipoDocumentoSelected to set
	 */
	public void setIdTipoDocumentoSelected(Integer idTipoDocumentoSelected) {
		this.idTipoDocumentoSelected = idTipoDocumentoSelected;
	}
	
	

	/**
	 * @return the listPerfil
	 */
	public List<Perfil> getListPerfil() {
		return listPerfil;
	}

	/**
	 * @param listPerfil the listPerfil to set
	 */
	public void setListPerfil(List<Perfil> listPerfil) {
		this.listPerfil = listPerfil;
	}

	/**
	 * @return the idPerfilSelected
	 */
	public Integer getIdPerfilSelected() {
		return idPerfilSelected;
	}

	/**
	 * @param idPerfilSelected the idPerfilSelected to set
	 */
	public void setIdPerfilSelected(Integer idPerfilSelected) {
		this.idPerfilSelected = idPerfilSelected;
	}
	
	

	/**
	 * @return the showField
	 */
	public boolean isShowField() {
		return showField;
	}

	/**
	 * @param showField the showField to set
	 */
	public void setShowField(boolean showField) {
		this.showField = showField;
	}

	@PostConstruct
	public void doInit() {
		try {		
			listTipoDocumento = tipoDocumentoService.findAll();
			listPerfil = perfilService.findAll();
			obtenerListUsuario();
			showField=true;
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	private void obtenerListUsuario() {
		try {
			accion="";
			pnlSearchOrViewData=false;		
			listUsuario = usuarioService.findAll();				
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}

	@Override
	public void agregar(ActionEvent ev) {
		accion="NEW";
		pnlSearchOrViewData=true;
		Persona persona = new Persona ();
		usuario = new Usuario();
		usuario.setPersona(persona);

	}

	@Override
	public void save(ActionEvent ev) {
		try {
			usuario.setEmpresa(usuarioLogueado().getEmpresa());
			usuario.getPersona().setTipoDocumento(new TipoDocumento(idTipoDocumentoSelected));
			usuario.setCodPerfil(new Perfil(idPerfilSelected));
			personaService.save(usuario.getPersona());
			usuarioService.save(usuario);
			obtenerListUsuario();
			messageInfo("Usuario", "Registrado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void update(ActionEvent ev) {
		try {
			usuario.getPersona().setTipoDocumento(new TipoDocumento(idTipoDocumentoSelected));
			usuario.setCodPerfil(new Perfil(idPerfilSelected));
			personaService.save(usuario.getPersona());
			usuarioService.save(usuario);
			obtenerListUsuario();
			messageInfo("Usuario", "Modificado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void delete(ActionEvent ev) {
		try {
			usuarioService.delete(usuario);
			personaService.delete(usuario.getPersona());
			obtenerListUsuario();
			messageInfo("Usuario", "Eliminado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	@Override
	public void search(ActionEvent ev) {
		obtenerListUsuario();		
	}

	@Override
	public void editar(ActionEvent ev) {
		accion="EDIT";		
		pnlSearchOrViewData=true;		
	}
	
	public void showPanel(){
	    showField = false;	   
	}
	
	public void editarUsuario(Usuario usuarioSelected) {
		editar(null);	
		this.usuario = usuarioSelected;
		this.idPerfilSelected = usuario != null ? usuario.getCodPerfil().getCodPerfil() : null;
	}

}
