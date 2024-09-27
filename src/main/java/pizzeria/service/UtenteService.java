package pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzeria.model.Utente;
import pizzeria.repo.UtenteRepository;
 

@Service
@Transactional
public class UtenteService {

	
	@Autowired
	UtenteRepository repo;
	
	public Utente getUserById(Integer id)
	{
 			return repo.findById(id).get();
 		
	}
	 
	public Utente getUser(String N, String P)
	{
		if(N==null||P==null) return null; 
		else
			return repo.findUserByNamePsw(P, N);
 		
	}
	
 
}


