package mx.com.guarderia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Alergia;
import mx.com.guarderia.repository.AlergiaRepository;
import mx.com.guarderia.service.AlergiaService;

@Service
public class AlergiaServiceImpl implements AlergiaService {
  
  @Autowired
  private AlergiaRepository alergiaRepository;
  
  @Override
  public boolean guardarAlergia(Alergia alergia) {
    alergiaRepository.save(alergia);
    return alergia.getId() == null ? false : true;
  }

  @Override
  public boolean actualizarAlergia(Alergia alergia) {
    
    if (alergia.getId() != null) {
      alergiaRepository.save(alergia);
      return true;
    }
    return false;
  }

  @Override
  public boolean eliminarAlergia(Long idAlergia) {
    Alergia alergia;
    if (idAlergia != null) {
      alergiaRepository.deleteById(idAlergia);
      alergia = obtenerAlergia(idAlergia);
      return alergia == null ? true : false;
    }
    return false;
  }

  @Override
  public Alergia obtenerAlergia(Long idAlergia) {
    
    return alergiaRepository.findById(idAlergia).orElse(null);
  }

  @Override
  public List<Alergia> obtenerAlergias() {
    Iterable<Alergia> it = alergiaRepository.findAll();
    List<Alergia> alergias = new ArrayList<Alergia>();
    it.forEach(alergias::add);
    return alergias;
  }

}
