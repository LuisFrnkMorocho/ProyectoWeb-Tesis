package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Usuario;
import ec.edu.ctrlsolutions.repository.UsuarioRepository;
import ec.edu.ctrlsolutions.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario autentificarUsuario(String username, String password) throws Exception {
		return usuarioRepository.findUsuarioByCredenciales(username, password);
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
		
	}

}
