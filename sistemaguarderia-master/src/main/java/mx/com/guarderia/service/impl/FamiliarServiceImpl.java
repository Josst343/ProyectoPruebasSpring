package mx.com.guarderia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.repository.FamiliarRepository;
import mx.com.guarderia.service.FamiliarService;


@Service
public class FamiliarServiceImpl implements FamiliarService {

  @Autowired
  private FamiliarRepository familiarRepository;
  
  @Override
  public boolean guardarFamiliar(Familiar familiar) {
    familiarRepository.save(familiar);
    if (familiar.getId() == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean actualizarFamiliar(Familiar familiar) {
    if (familiar.getId() == null) {
      return false;
    }
    familiarRepository.save(familiar);
    return true;
  }

  @Override
  public boolean eliminarFamiliar(Long idFamiliar) {
    Familiar familiar;
    if (idFamiliar != null) {
      familiarRepository.deleteById(idFamiliar);
      familiar = obtenerFamiliar(idFamiliar);
      if (familiar == null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Familiar obtenerFamiliar(Long idFamiliar) {
    return familiarRepository.findById(idFamiliar).orElse(null);
  }

}
