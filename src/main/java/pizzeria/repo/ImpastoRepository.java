package pizzeria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pizzeria.model.Impasto;
@Repository
public interface ImpastoRepository extends JpaRepository<Impasto, Integer> {

}
