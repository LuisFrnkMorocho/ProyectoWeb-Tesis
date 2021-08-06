package ec.edu.ctrlsolutions.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Empresa;
import ec.edu.ctrlsolutions.service.EmpresaService;

@Named(value = "empresaViewController")
@ViewScoped
public class EmpresaViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(EmpresaViewController.class.getName());

	@Autowired
	private EmpresaService empresaService;
	private List<Empresa> listEmpresa;
	private Empresa empresa;
	public boolean pnlSearchOrViewData=false;
	public String accion="";

	public EmpresaViewController() {
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
	 * @return the listEmpresa
	 */
	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	/**
	 * @param listEmpresa the listEmpresa to set
	 */
	public void setListEmpresa(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
			obtenerListEmpresa();			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	private void obtenerListEmpresa() {
		try {
			accion="";
			pnlSearchOrViewData=false;		
			listEmpresa = empresaService.findAll();		
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}

	@Override
	public void agregar(ActionEvent ev) {
		accion="NEW";
		pnlSearchOrViewData=true;
		empresa = new Empresa();

	}

	@Override
	public void save(ActionEvent ev) {
		try {
			empresaService.save(empresa);
			obtenerListEmpresa();
			messageInfo("Empresa", "Registrado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void update(ActionEvent ev) {
		try {
			empresaService.save(empresa);
			obtenerListEmpresa();
			messageInfo("Empresa", "Modificado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void delete(ActionEvent ev) {
		try {
			empresaService .delete(empresa);
			obtenerListEmpresa();
			messageInfo("Tipo Servicio", "Eliminado Correctamente.");			
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	@Override
	public void search(ActionEvent ev) {
		obtenerListEmpresa();		
	}

	@Override
	public void editar(ActionEvent ev) {
		accion="EDIT";		
		pnlSearchOrViewData=true;
	}

}
