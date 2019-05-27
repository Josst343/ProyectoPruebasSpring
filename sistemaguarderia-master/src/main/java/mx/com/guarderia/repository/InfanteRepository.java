package mx.com.guarderia.repository;

import mx.com.guarderia.domain.Infante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InfanteRepository extends CrudRepository<Infante,Long> {

}
