package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ctrlsolutions.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
