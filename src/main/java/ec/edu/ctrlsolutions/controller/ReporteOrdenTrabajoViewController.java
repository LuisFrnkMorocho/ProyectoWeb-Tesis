package ec.edu.ctrlsolutions.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;

import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.service.OrdenTrabajoService;

@Named(value = "reporteOrdenTrabajoViewController")
@ViewScoped
public class ReporteOrdenTrabajoViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(OrdenesTrabajoViewController.class.getName());

	@Autowired
	private OrdenTrabajoService ordenTrabajoService;
	public boolean pnlSearchOrViewData=false;
	public String accion="";
	
	private List<OrdenTrabajo> listOrdenTrabajo;


	public ReporteOrdenTrabajoViewController() {
		super();
	}

	// getters and setters

	/**
	 * @return the listOrdenTrabajo
	 */
	public List<OrdenTrabajo> getListOrdenTrabajo() {
		return listOrdenTrabajo;
	}

	/**
	 * @param listOrdenTrabajo the listOrdenTrabajo to set
	 */
	public void setListOrdenTrabajo(List<OrdenTrabajo> listOrdenTrabajo) {
		this.listOrdenTrabajo = listOrdenTrabajo;
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

	public void doInit() {
		try {	
			obtenerListOrdenTrabajo();			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	

	private void obtenerListOrdenTrabajo() {
		try {
			accion="";
			pnlSearchOrViewData=false;	
			if(isAdministrador()) {
				LOGGER.info("INFORMACIÓN MODO ADMINISTARDOR");
			listOrdenTrabajo = ordenTrabajoService.findAll();
			}else {
				LOGGER.info("INFORMACIÓN MODO TÉCNICO");
				listOrdenTrabajo = ordenTrabajoService.findOrdenTrabajoByUsuario(usuarioLogueado());
			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}
	
	public void preProcessPDF(Object document) {
	      Document pdf = (Document) document;
	      pdf.open();
	      pdf.setPageSize(PageSize.A4.rotate());
	    }

	@Override
	public void agregar(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(ActionEvent ev) {
		// TODO Auto-generated method stub
		
	}

	

}
