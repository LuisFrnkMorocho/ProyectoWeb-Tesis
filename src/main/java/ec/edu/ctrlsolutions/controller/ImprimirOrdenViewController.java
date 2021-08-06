package ec.edu.ctrlsolutions.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.service.EquipoService;
import ec.edu.ctrlsolutions.service.GenerateReportService;
import net.sf.jasperreports.engine.JRException;

@Named(value = "imprimirOrdenViewController")
@ViewScoped
public class ImprimirOrdenViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(ImprimirOrdenViewController.class.getName());

	@Autowired
	private EquipoService equipoService;
	@Autowired
	private GenerateReportService generateReportService;
	
	private List<Equipo> listEquipo;
	public boolean pnlSearchOrViewData=false;
	public String accion="";
	private StreamedContent content;
	
	private Integer codOrdenTrabajoSelected;

	public ImprimirOrdenViewController() {
		super();
		pnlSearchOrViewData=false;	
		listEquipo = null;
		content = null;
	}

	// getters and setters

	

	/**
	 * @return the pnlSearchOrViewData
	 */
	public boolean isPnlSearchOrViewData() {
		return pnlSearchOrViewData;
	}

	/**
	 * @return the content
	 */
	public StreamedContent getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(StreamedContent content) {
		this.content = content;
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
	 * @return the listEquipo
	 */
	public List<Equipo> getListEquipo() {
		return listEquipo;
	}

	/**
	 * @param listEquipo the listEquipo to set
	 */
	public void setListEquipo(List<Equipo> listEquipo) {
		this.listEquipo = listEquipo;
	}
	
	

	/**
	 * @return the codOrdenTrabajoSelected
	 */
	public Integer getCodOrdenTrabajoSelected() {
		return codOrdenTrabajoSelected;
	}

	/**
	 * @param codOrdenTrabajoSelected the codOrdenTrabajoSelected to set
	 */
	public void setCodOrdenTrabajoSelected(Integer codOrdenTrabajoSelected) {
		this.codOrdenTrabajoSelected = codOrdenTrabajoSelected;
	}

	private void obtenerListOrdenTrabajo() {
		try {
			accion="";
			pnlSearchOrViewData=true;		
			listEquipo = equipoService.findEquipoByUserLoguedo(usuarioLogueado(), new OrdenTrabajo(codOrdenTrabajoSelected));
			if(getValidarBusqueda()) {
			content = pdfDocumentGenerate();
			}else {				
				messageWarn("Reporte:", "No se encontraron registros para su búsqueda.");
			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}

	
	
	public DefaultStreamedContent pdfDocumentGenerate() throws Exception {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String reportPath = facesContext.getExternalContext().getRealPath("/report")+ File.separator;
            String fileName = "reporteOrdenTrabajo.jasper";
            fileName = reportPath + fileName;
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("LOGO", facesContext.getExternalContext().getRealPath("resources/images"));
            parameterMap.put("EMPRESA", usuarioLogueado().getEmpresa().getNombre());
            parameterMap.put("RUC", usuarioLogueado().getEmpresa().getRuc());
            parameterMap.put("DIRECCION", usuarioLogueado().getEmpresa().getDireccion());
            parameterMap.put("TELEFONO", usuarioLogueado().getEmpresa().getTelefono());
            byte[] document = generateReportService.generateReportBytes(parameterMap, fileName, listEquipo);
            return new DefaultStreamedContent(new ByteArrayInputStream(document), "application/pdf", "Actor_List");
        } catch (JRException ex) {
            // Logger.getLogger(BasicDocumentViewerController.class.getName()).log(Level.SEVERE,
            // null, ex);
            return null;
        }
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
		obtenerListOrdenTrabajo();
		
	}
	
	public boolean getValidarBusqueda() {
		return listEquipo!=null && !listEquipo.isEmpty();
		
	}

}
