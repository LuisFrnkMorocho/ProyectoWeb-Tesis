package ec.edu.ctrlsolutions.controller;

import javax.faces.event.ActionEvent;

public abstract class GestionController extends BaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7930944995730854327L;
	
	public abstract void agregar(ActionEvent ev);
	
	public abstract void editar(ActionEvent ev);
	
	public abstract void save(ActionEvent ev);
	
	public abstract void update(ActionEvent ev);
	
	public abstract void delete(ActionEvent ev);
	
	public abstract void search(ActionEvent ev);

}
