package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ctrlsolutions.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
