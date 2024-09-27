package pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzeria.model.Pizza; 
import pizzeria.repo.PizzaRepository;

@Service
@Transactional
public class PizzaService {
	@Autowired
	PizzaRepository repo;

	public List<Pizza> findAll() {

		return repo.findAll();

	}

	public Pizza findById(Integer id) {

		return repo.findById(id).get();

	}

	public void save(Pizza p) {
 		repo.save(p);
	}

	public void delete(int id) {

		repo.deleteById(id);
	}

 public void update(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

}
