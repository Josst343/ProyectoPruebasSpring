package mx.com.guarderia.service;

import java.util.List;
import mx.com.guarderia.domain.Alergia;

import org.springframework.stereotype.Service;




/**
 * 
 * @author Luis David
 *
 */
@Service
public interface AlergiaService {
  /**
   * 
   * @param alergia Es un objeto de tipo Alergia.
   * @return booleano Indica su se guardo correctamente una alergía
   */
  public boolean guardarAlergia(Alergia alergia);
  
  /**
   * 
   * @param alergia Es un objeto de tipo Alergia.
   * @return booleano Indica su se actualizo correctamente una alergía
   */
  public boolean actualizarAlergia(Alergia alergia);
  
  /**
   * 
   * @param idAlergia Identificador de tipo Long de una alergia.
   * @return boolean Para indicar si se elemino correctamente la alergia.
   */
  public boolean eliminarAlergia(Long idAlergia);
  
  /**
   * 
   * @param idAlergia Identificador de tipo Long de una alergia.
   * @return Alergia Objeto Alergia
   */
  public Alergia obtenerAlergia(Long idAlergia);
  
  /**
   * 
   * @return List Una lista de todas las alergia almacenadas previamente en la BD
   */  
  public List<Alergia> obtenerAlergias();

}
