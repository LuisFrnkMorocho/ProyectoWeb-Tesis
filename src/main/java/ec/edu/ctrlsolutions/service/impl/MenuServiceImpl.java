package ec.edu.ctrlsolutions.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.model.Menu;
import ec.edu.ctrlsolutions.repository.MenuRepository;
import ec.edu.ctrlsolutions.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	 
	@Override
	public List<Menu> findAll(){
		return menuRepository.findAll();
	}

}
