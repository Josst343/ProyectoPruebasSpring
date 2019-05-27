package mx.com.guarderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Infante;

@Service
public interface InfanteService {
  /**
   * 
   * @param infante Objeto Infante
   * @return boolean devuelve verdadero si guarda el infante
   */
  public boolean guardarInfante(Infante infante);
  /**
   * 
   * @param infante Objeto de tipo infante
   * @return boolean devuelve verdadero si actualiza el infante
   */
  public boolean actualizarInfante(Infante infante);
  
  /**
   * 
   * @param idInfante Identificador de un infante
   * @return boolean devuelve verdadero si elimina el infante
   */
  public boolean eliminarInfante(Long idInfante);
  
  /**
   * 
   * @param idInfante Indentificador de un infante
   * @return Infante Devuelve null si no encuentra el infante
   */
  public Infante obtenerInfante(Long idInfante);
  
  /**
   * 
   * @return List<Infante> regresa una lista de infantes.
   */
  public List<Infante> obtenerInfantes();
}
