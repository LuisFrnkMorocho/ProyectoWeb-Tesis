package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ctrlsolutions.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.username = ?1 AND u.password = ?2")
	Usuario findUsuarioByCredenciales(String username, String password);
}
