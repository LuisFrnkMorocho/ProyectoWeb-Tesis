package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ctrlsolutions.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	@Query("SELECT p FROM Persona p WHERE p.identificacion = ?1")
	Persona findPersonaByIdentificacion(String identificacion);

}
