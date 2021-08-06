package ec.edu.ctrlsolutions.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.TipoDocumento;
import ec.edu.ctrlsolutions.repository.TipoDocumentoRepository;

@Named(value = "tipoDocumentoViewController")
@ViewScoped
public class TipoDocumentoViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(TipoDocumentoViewController.class.getName());

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	private List<TipoDocumento> listTipoDocumento;
	private TipoDocumento tipoDocumento;
	public boolean pnlSearchOrViewData=false;
	public String accion="";

	public TipoDocumentoViewController() {
		super();
	}

	// getters and setters

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
	 * @return the tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the pnlSearchOrViewData
	 */
	public boolean isPnlSearchOrViewData() {
		return pnlSearchOrViewData;
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

	@PostConstruct
	public void doInit() {
		try {			
			obtenerListTipoDocumento();			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	private void obtenerListTipoDocumento() {
		try {
			accion="";
			pnlSearchOrViewData=false;		
			listTipoDocumento = tipoDocumentoRepository.findAll();		
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}

	@Override
	public void agregar(ActionEvent ev) {
		accion="NEW";
		pnlSearchOrViewData=true;
		tipoDocumento = new TipoDocumento();

	}

	@Override
	public void save(ActionEvent ev) {
		try {
			tipoDocumentoRepository.save(tipoDocumento);
			obtenerListTipoDocumento();
			messageInfo("Tipo Documento", "Registrado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void update(ActionEvent ev) {
		try {
			tipoDocumentoRepository.save(tipoDocumento);
			obtenerListTipoDocumento();
			messageInfo("Tipo Documento", "Modificado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void delete(ActionEvent ev) {
		try {
			tipoDocumentoRepository.delete(tipoDocumento);
			obtenerListTipoDocumento();
			messageInfo("Tipo Documento", "Eliminado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	@Override
	public void search(ActionEvent ev) {
		obtenerListTipoDocumento();		
	}

	@Override
	public void editar(ActionEvent ev) {
		accion="EDIT";		
		pnlSearchOrViewData=true;
	}

}
