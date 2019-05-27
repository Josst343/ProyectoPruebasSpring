package mx.com.guarderia.repository;

import mx.com.guarderia.domain.Familiar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliarRepository extends CrudRepository<Familiar,Long> {

}
