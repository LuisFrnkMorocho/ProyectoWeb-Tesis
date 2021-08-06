package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.edu.ctrlsolutions.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
	
	@Query("SELECT t FROM TipoDocumento t WHERE t.codTipoDocumento = ?1")
	TipoDocumento findTipoDocumentoById(Integer id);

}
