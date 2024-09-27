package pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzeria.model.Ingrediente;
import pizzeria.repo.IngredienteRepository;

  
@Service
@Transactional
public class IngredienteService {

	@Autowired
	IngredienteRepository repo;

	public List<Ingrediente> findAll() {

		return repo.findAll();

	}
	public Ingrediente findOrNull(int id) {
 	    Optional<Ingrediente> op = repo.findById(id);
 	   Ingrediente i = op.orElse(null);
 	    return i;
	}
	
	
	
	public Ingrediente findById(Integer id) {
		return  repo.findById(id).get();    
		   
	}

	public void save(Ingrediente i) {
		repo.save(i);
	}

	public void delete(int id) {

		repo.deleteById(id);
	}
}
