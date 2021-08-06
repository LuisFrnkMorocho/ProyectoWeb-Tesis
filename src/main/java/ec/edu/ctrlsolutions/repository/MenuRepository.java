package ec.edu.ctrlsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ctrlsolutions.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
