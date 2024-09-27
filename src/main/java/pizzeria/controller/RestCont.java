package pizzeria.controller;

import java.util.List;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pizzeria.model.*;
import pizzeria.repo.*;

@RestController
public class RestCont {
 
	@Autowired
	ImpastoRepository impastoRepo;
	@Autowired
	IngredienteRepository ingredienteRepo;
	@Autowired
	UtenteRepository utenteRepo;

	@RequestMapping(path = "/impasti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Impasto> getAllImpasti( ) {
		return impastoRepo.findAll();
	}

	@RequestMapping(path = "/impasti/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Impasto getImpasto(@PathVariable Integer id) {
		return impastoRepo.findById(id).get();

	}

	@RequestMapping(path = "/impasti", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Impasto insertImpasto(@RequestBody  Impasto i) {
		return impastoRepo.save(i);

	}

	@RequestMapping(path = "/impasti/delete/{id}", produces =  MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public void deleteImpasto(@PathVariable int id) {
		 
		impastoRepo.delete(impastoRepo.findById(id).get());

	}

	
	@RequestMapping(path="impasti/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
	
	public void updateImpasto(@RequestBody Impasto i, @PathVariable int id) {
		Impasto moddato = impastoRepo.findById(id).get();
		moddato.setNome(i.getNome());
		impastoRepo.save(moddato);		
 	}

 
	////////////////////////////////////////// INGREDIENTI

	@RequestMapping(path = "/ingredienti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Ingrediente> getAllIngredienti( ) {
		return ingredienteRepo.findAll();
	}

	@RequestMapping(path = "/ingredienti/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Ingrediente getIngrediente(@PathVariable Integer id) {
		return ingredienteRepo.findById(id).get();

	}

	@RequestMapping(path = "/ingredienti", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Ingrediente insertIngrediente(@RequestBody Ingrediente i) {
		return ingredienteRepo.save(i);

	}

	@RequestMapping(path = "/ingredienti/delete/{id}", produces =  MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public void deleteIngrediente(@PathVariable int id) {
		 
		ingredienteRepo.delete(ingredienteRepo.findById(id).get());

	}
   	  
	@RequestMapping(path="ingredienti/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT) 
 
	public void updateIngrediente(@RequestBody Ingrediente i, @PathVariable int id) {
		
		Ingrediente moddato = ingredienteRepo.findById(id).get();
		moddato.setNome(i.getNome());
		ingredienteRepo.save(moddato);
		
 	}

 
	////////////////////////////////// UTENTI

	@RequestMapping(path = "/utenti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public List<Utente> getAllUtenti() {
		return utenteRepo.findAll();
	}

	@RequestMapping(path = "/utenti/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Utente getUtente(@PathVariable Integer id) {
		return utenteRepo.findById(id).get();

	}

	@RequestMapping(path = "/utenti", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Utente insertUtente(@RequestBody Utente i) {
		return utenteRepo.save(i);

	}

	@RequestMapping(path = "/utenti/delete/{id}", produces =  MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public void deleteUtente(@PathVariable int id) {
		 
		utenteRepo.delete(utenteRepo.findById(id).get());

	}
	 
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, path="")
	public void updateUtente (@RequestBody Utente u, @PathVariable int id)
	{
		Utente moddato = utenteRepo.findById(id).get();
		moddato.setPsw(u.getPsw());
		moddato.setUsername(u.getUsername());
		utenteRepo.save(moddato);
		
	}

}
