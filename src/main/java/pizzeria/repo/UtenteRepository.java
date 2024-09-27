package pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pizzeria.model.Utente;

  @Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	
	
	@Query("SELECT u FROM Utente u WHERE u.psw = ?1 and u.username=?2")
	Utente findUserByNamePsw(String psw, String name);
	
 
}
