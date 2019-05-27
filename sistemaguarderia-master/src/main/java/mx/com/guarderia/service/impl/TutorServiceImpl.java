package mx.com.guarderia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.repository.TutorRepository;
import mx.com.guarderia.service.TutorService;


@Service
public class TutorServiceImpl implements TutorService {
  
  @Autowired
  private TutorRepository tutorRepository;
  
  @Override
  public Tutor obtenerTutor(Long idTutor) {
    
    return tutorRepository.findById(idTutor).orElse(null);
  }

  @Override
  public boolean guardarTutor(Tutor tutor) {
    
    tutorRepository.save(tutor);
    if (tutor.getId() == null) {
      return false;
    }
    
    return true;
  }

  @Override
  public boolean actualizarTutor(Tutor tutor) {
    if (tutor.getId() == null) {
      return false;
    }
    tutorRepository.save(tutor);
    return true;
  }

  @Override
  public boolean eliminarTutor(Long idTutor) {
    if (idTutor == null) {
      return false;
    }
    tutorRepository.deleteById(idTutor);
    return true;
  }

  @Override
  public List<Tutor> obtenerTutores() {
    Iterable<Tutor> it=tutorRepository.findAll();
    ArrayList<Tutor> tutores=new ArrayList<Tutor>();  
    it.iterator().forEachRemaining(tutores::add);
    return tutores;
  }

  
}
