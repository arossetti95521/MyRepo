package pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pizzeria.model.Pizza;
@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> { 

}
