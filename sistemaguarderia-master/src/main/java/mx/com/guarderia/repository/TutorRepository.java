package mx.com.guarderia.repository;

import mx.com.guarderia.domain.Tutor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TutorRepository extends CrudRepository<Tutor,Long> {

}
