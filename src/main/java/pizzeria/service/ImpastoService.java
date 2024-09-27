package pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzeria.model.Impasto;
 import pizzeria.repo.ImpastoRepository;

@Service
@Transactional
public class ImpastoService {
	@Autowired
	ImpastoRepository repo;

	public List<Impasto> findAll() {

		return repo.findAll();

	}
	public Impasto findOrNull(int id) {
 	    Optional<Impasto> op = repo.findById(id);
 	   Impasto i = op.orElse(null);
 	    return i;
	}
	
	public Impasto findById(Integer id) {

		return repo.findById(id).get();

	}

	public void save(Impasto i) {
		repo.save(i);
	}

	public void delete(int id) {

		repo.deleteById(id);
	}
}
