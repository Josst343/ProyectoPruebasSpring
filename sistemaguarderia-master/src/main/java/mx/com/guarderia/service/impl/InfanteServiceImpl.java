package mx.com.guarderia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.repository.InfanteRepository;
import mx.com.guarderia.service.InfanteService;

@Service
public class InfanteServiceImpl implements InfanteService {

  @Autowired
  private InfanteRepository infanteRepository;
  
  @Override
  public boolean guardarInfante(Infante infante) {
    infanteRepository.save(infante);
    if (infante.getMatricula() == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean actualizarInfante(Infante infante) {
    if (infante.getMatricula() == null) {
      return false;
    }
    infanteRepository.save(infante);
    return true;
  }

  @Override
  public boolean eliminarInfante(Long idInfante) {
    Infante infante;
    if (idInfante != null) {
      infanteRepository.deleteById(idInfante);
      infante = obtenerInfante(idInfante);
      if (infante == null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Infante obtenerInfante(Long idInfante) {

    return infanteRepository.findById(idInfante).orElse(null);
  }

  @Override
  public List<Infante> obtenerInfantes() {
    Iterable<Infante> it = infanteRepository.findAll();
    ArrayList<Infante> infantes= new ArrayList<Infante>();
    it.iterator().forEachRemaining(infantes::add);
    return infantes;
  }

}
