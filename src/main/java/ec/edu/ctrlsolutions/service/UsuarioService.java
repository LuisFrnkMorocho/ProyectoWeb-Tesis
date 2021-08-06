package ec.edu.ctrlsolutions.service;

import java.util.List;

import ec.edu.ctrlsolutions.model.Usuario;

public interface UsuarioService {	
	List<Usuario> findAll();
	Usuario autentificarUsuario (String username, String password) throws Exception;
	void save(Usuario usuario);
	void delete(Usuario usuario);
}
