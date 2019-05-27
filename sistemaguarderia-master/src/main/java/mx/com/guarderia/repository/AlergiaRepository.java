package mx.com.guarderia.repository;

import mx.com.guarderia.domain.Alergia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergiaRepository extends CrudRepository<Alergia,Long> {

}
