package ec.edu.ctrlsolutions.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ctrlsolutions.model.Cliente;
import ec.edu.ctrlsolutions.model.Diagnostico;
import ec.edu.ctrlsolutions.model.Equipo;
import ec.edu.ctrlsolutions.model.OrdenTrabajo;
import ec.edu.ctrlsolutions.model.OrdenTrabajoDetalle;
import ec.edu.ctrlsolutions.model.Persona;
import ec.edu.ctrlsolutions.model.ReporteDTO;
import ec.edu.ctrlsolutions.model.TipoDocumento;
import ec.edu.ctrlsolutions.model.TipoServicio;
import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.service.DiagnosticoService;
import ec.edu.ctrlsolutions.service.EquipoService;
import ec.edu.ctrlsolutions.service.GenerateReportService;
import ec.edu.ctrlsolutions.service.OrdenTrabajoDetalleService;
import ec.edu.ctrlsolutions.service.OrdenTrabajoService;
import ec.edu.ctrlsolutions.service.PersonaService;
import ec.edu.ctrlsolutions.service.TipoDocumentoService;
import ec.edu.ctrlsolutions.service.TipoServicioService;
import ec.edu.ctrlsolutions.service.UsuarioService;
import net.sf.jasperreports.engine.JRException;

@Named(value = "ordenesTrabajoViewController")
@ViewScoped
public class OrdenesTrabajoViewController extends GestionController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7665852885047076877L;
	private final static Logger LOGGER = Logger.getLogger(OrdenesTrabajoViewController.class.getName());

	@Autowired
	private OrdenTrabajoService ordenTrabajoService;
	@Autowired
	private OrdenTrabajoDetalleService ordenTrabajoDetalleService;
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	@Autowired
	private EquipoService equipoService;
	@Autowired
	private TipoServicioService tipoServicioService;
	@Autowired
	private UsuarioService usuarioServicioService;
	@Autowired
	private DiagnosticoService diagnosticoService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private GenerateReportService generateReportService;
	private List<TipoDocumento> listTipoDocumento;
	private List<TipoServicio> listTipoServicio;
	private List<OrdenTrabajo> listOrdenTrabajo;
	private List<Equipo> listEquipo;
	private List<Usuario> listUsuario;
	private List<Equipo> listEquipoSelected;
	private OrdenTrabajo ordenTrabajo;
	private Cliente cliente;
	private Diagnostico diagnostico;
	public boolean pnlSearchOrViewData = false;
	public String accion = "";
	public Integer idTipoDocumentoSelected;
	public Integer idTipoServicioSelected;
	public Integer idUsuarioSelected;
	private Equipo equipo;
	private boolean isFinalizado;
	private String identificacionSelected;
	private StreamedContent content;
	private List<ReporteDTO> resultReporte;

	public OrdenesTrabajoViewController() {
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
	 * @return the ordenTrabajo
	 */
	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	/**
	 * @param ordenTrabajo the ordenTrabajo to set
	 */
	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	 * @return the equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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
	 * @return the idTipoServicioSelected
	 */
	public Integer getIdTipoServicioSelected() {
		return idTipoServicioSelected;
	}

	/**
	 * @param idTipoServicioSelected the idTipoServicioSelected to set
	 */
	public void setIdTipoServicioSelected(Integer idTipoServicioSelected) {
		this.idTipoServicioSelected = idTipoServicioSelected;
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
	 * @return the idUsuarioSelected
	 */
	public Integer getIdUsuarioSelected() {
		return idUsuarioSelected;
	}

	/**
	 * @param idUsuarioSelected the idUsuarioSelected to set
	 */
	public void setIdUsuarioSelected(Integer idUsuarioSelected) {
		this.idUsuarioSelected = idUsuarioSelected;
	}

	/**
	 * @return the diagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the isFinalizado
	 */
	public boolean isFinalizado() {
		return isFinalizado;
	}

	/**
	 * @param isFinalizado the isFinalizado to set
	 */
	public void setFinalizado(boolean isFinalizado) {
		this.isFinalizado = isFinalizado;
	}

	/**
	 * @return the listEquipoSelected
	 */
	public List<Equipo> getListEquipoSelected() {
		return listEquipoSelected;
	}

	/**
	 * @param listEquipoSelected the listEquipoSelected to set
	 */
	public void setListEquipoSelected(List<Equipo> listEquipoSelected) {
		this.listEquipoSelected = listEquipoSelected;
	}

	/**
	 * @return the identificacionSelected
	 */
	public String getIdentificacionSelected() {
		return identificacionSelected;
	}

	/**
	 * @param identificacionSelected the identificacionSelected to set
	 */
	public void setIdentificacionSelected(String identificacionSelected) {
		this.identificacionSelected = identificacionSelected;
	}
	
	
	
	

	/**
	 * @return the resultReporte
	 */
	public List<ReporteDTO> getResultReporte() {
		return resultReporte;
	}

	/**
	 * @param resultReporte the resultReporte to set
	 */
	public void setResultReporte(List<ReporteDTO> resultReporte) {
		this.resultReporte = resultReporte;
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

	public void doInit() {
		try {
			listTipoDocumento = tipoDocumentoService.findAll();
			listTipoServicio = tipoServicioService.findAll();
			listUsuario = usuarioServicioService.findAll();
			obtenerListOrdenTrabajo();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	private void obtenerListOrdenTrabajo() {
		try {
			accion = "";
			pnlSearchOrViewData = false;
			if (isAdministrador()) {
				LOGGER.info("INFORMACIÓN MODO ADMINISTARDOR");
				listOrdenTrabajo = ordenTrabajoService.findAll();
			} else {
				LOGGER.info("INFORMACIÓN MODO TÉCNICO");
				listOrdenTrabajo = ordenTrabajoService.findOrdenTrabajoByUsuario(usuarioLogueado());
			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void agregar(ActionEvent ev) {
		accion = "NEW";
		identificacionSelected = "";
		pnlSearchOrViewData = true;
		ordenTrabajo = new OrdenTrabajo();
		Persona persona = new Persona();
		cliente = new Cliente();
		cliente.setPersona(persona);

	}

	@Override
	public void save(ActionEvent ev) {
		try {
            TipoDocumento documento = tipoDocumentoService.findTipoDocumentoById(idTipoDocumentoSelected);
            if(documento!=null) {
            	if (cliente.getPersona().getIdentificacion() == null
        				|| "".equals(cliente.getPersona().getIdentificacion())) {
        			messageError("Error:", "El campo Identificación es Obligatorio.");
        			return;
        		}else if("RUC".equals(documento.getDescripcion())&&cliente.getPersona().getIdentificacion().length()!=13){
        			messageError("Error:", "El campo Identificación no es valido para el formato RUC.");
        			return;        			
        		}
            	
        		else if("CEDULA".equals(documento.getDescripcion())&&cliente.getPersona().getIdentificacion().length()!=10){
        			messageError("Error:", "El campo Identificación no es valido para el formato CÉDULA.");
        			return;        			
        		}	
            	
            }else {
            	messageError("Error:", "El campo Tipo de Identificación es Obligatorio.");
    			return;
            }
            if (cliente.getPersona().getApellido() == null || "".equals(cliente.getPersona().getApellido())) {
    			messageError("Error:", "El campo Apellido es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getNombre() == null || "".equals(cliente.getPersona().getNombre())) {
    			messageError("Error:", "El campo Nombre es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getEmail() == null || "".equals(cliente.getPersona().getEmail())) {
    			messageError("Error:", "El campo Correo Electrónico es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getTelefono() == null || "".equals(cliente.getPersona().getTelefono())) {
    			messageError("Error:", "El campo Teléfono es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getDireccion() == null || "".equals(cliente.getPersona().getDireccion())) {
    			messageError("Error:", "El campo Dirección es Obligatorio.");
    			return;
    		}
    		
    		cliente.getPersona().setTipoDocumento(documento);
			ordenTrabajo.setCliente(cliente);
			ordenTrabajoService.guardarOrdenTrabajoPorCliente(ordenTrabajo);
			obtenerListOrdenTrabajo();
			ordenTrabajo = ordenTrabajoService.findOrdenTrabajoById(ordenTrabajo.getCodOrdenTrabajo());
			editarOrdenTrabajo(ordenTrabajo);
			messageInfo("Orden de Trabajo", "Registrado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void update(ActionEvent ev) {
		try {
			TipoDocumento documento = tipoDocumentoService.findTipoDocumentoById(idTipoDocumentoSelected);
            if(documento!=null) {
            	if (cliente.getPersona().getIdentificacion() == null
        				|| "".equals(cliente.getPersona().getIdentificacion())) {
        			messageError("Error:", "El campo Identificación es Obligatorio.");
        			return;
        		}else if("RUC".equals(documento.getDescripcion())&&cliente.getPersona().getIdentificacion().length()!=13){
        			messageError("Error:", "El campo Identificación no es valido para el formato RUC.");
        			return;        			
        		}
            	
        		else if("CEDULA".equals(documento.getDescripcion())&&cliente.getPersona().getIdentificacion().length()!=10){
        			messageError("Error:", "El campo Identificación no es valido para el formato CÉDULA.");
        			return;        			
        		}	
            	
            }else {
            	messageError("Error:", "El campo Tipo de Identificación es Obligatorio.");
    			return;
            }
            if (cliente.getPersona().getApellido() == null || "".equals(cliente.getPersona().getApellido())) {
    			messageError("Error:", "El campo Apellido es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getNombre() == null || "".equals(cliente.getPersona().getNombre())) {
    			messageError("Error:", "El campo Nombre es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getEmail() == null || "".equals(cliente.getPersona().getEmail())) {
    			messageError("Error:", "El campo Correo Electrónico es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getTelefono() == null || "".equals(cliente.getPersona().getTelefono())) {
    			messageError("Error:", "El campo Teléfono es Obligatorio.");
    			return;
    		}

    		if (cliente.getPersona().getDireccion() == null || "".equals(cliente.getPersona().getDireccion())) {
    			messageError("Error:", "El campo Dirección es Obligatorio.");
    			return;
    		}
    		cliente.getPersona().setTipoDocumento(documento);
    		ordenTrabajo.setCliente(cliente);
			ordenTrabajoService.guardarOrdenTrabajoPorCliente(ordenTrabajo);
			messageInfo("Órdenes de Trabajo", "Modificado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	public void finalizaOrdenRevision(ActionEvent ev) {
		try {
			List<String> listEstado = Stream.of("INGRESADO", "ASIGNADO").collect(Collectors.toList());
			if (ordenTrabajoDetalleService.existeOrdenNoFinalizadoRevision(ordenTrabajo, listEstado) > 0) {
				messageError("Órdenes de Trabajo", "Existen Órdenes Pendientes en Revisión.");
				return;
			}
			ordenTrabajo.setEstado("REVISADO");
			ordenTrabajoService.save(ordenTrabajo);
			obtenerListOrdenTrabajo();
			messageInfo("Órdenes de Trabajo", "Finalizando Revisión Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}
	
	
	public void finalizarEntregaOrden(ActionEvent ev) {
		try {
			List<String> listEstado = Stream.of("INGRESADO", "ASIGNADO", "REVISADO", "PORREPARAR").collect(Collectors.toList());
			if (ordenTrabajoDetalleService.existeOrdenNoFinalizadoRevision(ordenTrabajo, listEstado) > 0) {
				messageError("Órdenes de Trabajo", "Existen Órdenes Pendientes en Revisión.");
				return;
			}
			ordenTrabajo.setEstado("ENTREGADO");
			ordenTrabajoService.save(ordenTrabajo);
			obtenerListOrdenTrabajo();
			messageInfo("Órdenes de Trabajo", "Finalizando Entrega Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	@Override
	public void delete(ActionEvent ev) {
		try {
			ordenTrabajoService.delete(ordenTrabajo);
			obtenerListOrdenTrabajo();
			messageInfo("Órdenes de Trabajo", "Eliminado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	@Override
	public void search(ActionEvent ev) {
		obtenerListOrdenTrabajo();
	}

	@Override
	public void editar(ActionEvent ev) {
		accion = "EDIT";
		pnlSearchOrViewData = true;
		identificacionSelected = "";
	}

	public void editarOrdenTrabajo(OrdenTrabajo ordenTrabajoSelected) {
		try {
			accion = "EDIT";
			pnlSearchOrViewData = true;
			this.ordenTrabajo = ordenTrabajoSelected;
			this.cliente = ordenTrabajo.getCliente();
			if (isAdministrador()) {
				this.listEquipo = equipoService.findEquipoByUserAdmin(ordenTrabajo);
			} else {
				this.listEquipo = equipoService.findEquipoByUserLoguedo(usuarioLogueado(), ordenTrabajo);

			}
			equipo = new Equipo();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	public void agregarOrdenDetalle(ActionEvent ev) {
		idTipoServicioSelected = null;
		idUsuarioSelected = null;
		equipo = new Equipo();
		OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
		ordenTrabajoDetalle.setOrdenTrabajo(ordenTrabajo);
		equipo.setOrdenTrabajoDetalle(ordenTrabajoDetalle);
	}

	public void saveOrdenDetalle(ActionEvent ev) {
		try {
			OrdenTrabajoDetalle ordenTrabajoDetalle = equipo.getOrdenTrabajoDetalle();
			ordenTrabajoDetalle
					.setUsuario(idUsuarioSelected != null ? new Usuario(idUsuarioSelected) : usuarioLogueado());
			ordenTrabajoDetalle.setEstado(idUsuarioSelected != null ? "ASIGNADO" : "INGRESADO");
			ordenTrabajoDetalle.setTipoServicio(new TipoServicio(idTipoServicioSelected));
			ordenTrabajoDetalleService.guardarOrdenDetallePorEquipo(ordenTrabajoDetalle, equipo);
			this.listEquipo = equipoService.findEquipoByUserAdmin(ordenTrabajo);
			messageInfo("Orden Detalle Trabajo", "Registrado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	public void editarOrdenDetalle(Equipo equipoSelected) {
		try {
			this.equipo = equipoSelected;
			this.idTipoServicioSelected = equipo.getOrdenTrabajoDetalle().getTipoServicio().getCodTipoServicio();
			this.idUsuarioSelected = equipo.getOrdenTrabajoDetalle().getUsuario().getCodUsuario();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	public void prepararEliminarOrdenDetalle(Equipo equipoSelected) {
		try {
			this.equipo = equipoSelected;
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	public void eliminarOrdenDetalle(ActionEvent evt) {
		try {
			OrdenTrabajoDetalle ordenTrabajoDetalle = equipo.getOrdenTrabajoDetalle();
			equipoService.delete(equipo);
			ordenTrabajoDetalleService.delete(ordenTrabajoDetalle);
			this.listEquipo = equipoService.findEquipoByUserAdmin(ordenTrabajo);
			messageInfo("Orden Detalle Trabajo", "Eliminado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	public void ingresarDiagnostico(Equipo equipoSelected) {
		try {

			this.diagnostico = diagnosticoService
					.findDiagnosticoByOrdenDetalle(equipoSelected.getOrdenTrabajoDetalle());
			isFinalizado = true;
			if (diagnostico == null) {
				isFinalizado = false;
				diagnostico = new Diagnostico();
				diagnostico.setObservacion(equipoSelected.getOrdenTrabajoDetalle().getMotivoMantenimiento());
				diagnostico.setUsuario(usuarioLogueado());
				diagnostico.setOrdenTrabajoDetalle(equipoSelected.getOrdenTrabajoDetalle());
			}
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
	}

	public void saveDiagnostico(ActionEvent ev) {
		try {
			diagnostico.setFechaDiagnostico(new Date());
			diagnosticoService.save(diagnostico);
			OrdenTrabajoDetalle ordenTrabajoDetalle = diagnostico.getOrdenTrabajoDetalle();
			ordenTrabajoDetalle.setEstado("REVISADO");
			ordenTrabajoDetalleService.save(ordenTrabajoDetalle);
			if (isAdministrador()) {
				this.listEquipo = equipoService.findEquipoByUserAdmin(ordenTrabajo);
			} else {
				this.listEquipo = equipoService.findEquipoByUserLoguedo(usuarioLogueado(), ordenTrabajo);
			}
			messageInfo("Diagnóstico", "Registrado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}
	
	public void diagnosticoReparacion(ActionEvent ev) {
		try {			
			diagnosticoService.save(diagnostico);
			OrdenTrabajoDetalle ordenTrabajoDetalle = diagnostico.getOrdenTrabajoDetalle();
			ordenTrabajoDetalle.setFechaEntrega(new Date());
			ordenTrabajoDetalle.setEstado("ENTREGADO");
			ordenTrabajoDetalleService.save(ordenTrabajoDetalle);
			if (isAdministrador()) {
				this.listEquipo = equipoService.findEquipoByUserAdmin(ordenTrabajo);
			} else {
				this.listEquipo = equipoService.findEquipoByUserLoguedo(usuarioLogueado(), ordenTrabajo);
			}
			messageInfo("Diagnóstico", "Registrado Correctamente.");
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}

	}

	public void buscarCliente(ActionEvent ev) {
		Persona persona = personaService.findPersonaByIdentificacion(identificacionSelected);
		if (persona != null) {
			cliente.setPersona(persona);
		}
	}

	public void reparacionOrdenDetalle(ActionEvent ev) {
		if (listEquipoSelected != null && !listEquipoSelected.isEmpty()) {
			for (Equipo equipo : listEquipoSelected) {
				OrdenTrabajoDetalle dto = equipo.getOrdenTrabajoDetalle();
				dto.setEstado("PORREPARAR");
				ordenTrabajoDetalleService.save(dto);

			}

			messageInfo("Orden Detalle Trabajo", "Actualizado Correctamente.");
		} else {

			messageError("Error:", "Seleccione al menos un Detalle de la Orden de Trabajo.");
		}
	}

	/**
	 * @return the isFinalizado orden detalle de trabajo
	 */
	public boolean isOrdenDetalleFinalizado() {
		return diagnostico != null && diagnostico.getOrdenTrabajoDetalle() !=null && "PORREPARAR".equals(diagnostico.getOrdenTrabajoDetalle().getEstado());
	}
	
	public void generarReporte(Equipo equipoSelected) {
		ingresarDiagnostico(equipoSelected);
		obtenerReporteDetalleTrabajo();		
	}
	
	private void obtenerReporteDetalleTrabajo() {
		try {	
			resultReporte= diagnosticoService.findByOrdenDetalleTrabajo(diagnostico.getOrdenTrabajoDetalle().getCodOrdenTrabajoDetalle());
			content = pdfDocumentGenerate();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			messageError("Error:", "Comuníquese con el Administrador del Sistema.");
		}
		
	}
	
	public DefaultStreamedContent pdfDocumentGenerate()  {
		try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String reportPath = facesContext.getExternalContext().getRealPath("/report")+ File.separator;
            String fileName = "reporteOrdenDetalle.jasper";
            fileName = reportPath + fileName;
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("LOGO", facesContext.getExternalContext().getRealPath("resources/images"));
            parameterMap.put("EMPRESA", usuarioLogueado().getEmpresa().getNombre());
            parameterMap.put("RUC", usuarioLogueado().getEmpresa().getRuc());
            parameterMap.put("DIRECCION", usuarioLogueado().getEmpresa().getDireccion());
            parameterMap.put("TELEFONO", usuarioLogueado().getEmpresa().getTelefono());
            parameterMap.put("NUM_ORDEN", diagnostico.getOrdenTrabajoDetalle().getOrdenTrabajo().getCodOrdenTrabajo());
            parameterMap.put("USUARIO", usuarioLogueado().getPersona().getNombre().concat(" ").concat(usuarioLogueado().getPersona().getApellido()));
            parameterMap.put("IDENTIFICACION", usuarioLogueado().getPersona().getIdentificacion());
            byte[] document = generateReportService.generateReportBytes(parameterMap, fileName, resultReporte);
            return DefaultStreamedContent.builder()
                    .name("reporteOrdenDetalle")
                    .contentType("application/pdf")
                    .stream(() -> new ByteArrayInputStream(document)).build();
        } catch (JRException ex) {
        	LOGGER.severe(ex.getMessage());
            return null;
        } catch (Exception e) {
        	LOGGER.severe(e.getMessage());
        	return null;
		}
		
    }
	
}
