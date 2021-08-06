package ec.edu.ctrlsolutions.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.TipoServicio;
import ec.edu.ctrlsolutions.service.TipoServicioService;

@Named(value = "tipoServicioViewController")
@ViewScoped
public class TipoServicioViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(TipoServicioViewController.class.getName());

	@Autowired
	private TipoServicioService tipoServicioService;
	private List<TipoServicio> listTipoServicio;
	private TipoServicio tipoServicio;
	public boolean pnlSearchOrViewData=false;
	public String accion="";

	public TipoServicioViewController() {
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
	 * @return the listTipoServicio
	 */
	public List<TipoServicio> getListTipoServicio() {
		return listTipoServicio;
	}

	/**
	 * @param listTipoServicio the listTipoServicio to set
	 */
	public void setListTipoServicio(List<TipoServicio> listTipoServicio) {
		this.listTipoServicio = listTipoServicio;
	}

	/**
	 * @return the tipoServicio
	 */
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio the tipoServicio to set
	 */
	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
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
			obtenerListTipoServicio();			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	private void obtenerListTipoServicio() {
		try {
			accion="";
			pnlSearchOrViewData=false;		
			listTipoServicio = tipoServicioService.findAll();		
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}

	@Override
	public void agregar(ActionEvent ev) {
		accion="NEW";
		pnlSearchOrViewData=true;
		tipoServicio = new TipoServicio();

	}

	@Override
	public void save(ActionEvent ev) {
		try {
			tipoServicioService.save(tipoServicio);
			obtenerListTipoServicio();
			messageInfo("Tipo Servicio", "Registrado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void update(ActionEvent ev) {
		try {
			tipoServicioService.save(tipoServicio);
			obtenerListTipoServicio();
			messageInfo("Tipo Servicio", "Modificado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void delete(ActionEvent ev) {
		try {
			tipoServicioService .delete(tipoServicio);
			obtenerListTipoServicio();
			messageInfo("Tipo Servicio", "Eliminado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	@Override
	public void search(ActionEvent ev) {
		obtenerListTipoServicio();		
	}

	@Override
	public void editar(ActionEvent ev) {
		accion="EDIT";		
		pnlSearchOrViewData=true;
	}

}
