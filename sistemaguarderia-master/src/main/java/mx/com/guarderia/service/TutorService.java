package mx.com.guarderia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.guarderia.domain.Tutor;

@Service
public interface TutorService {
  /**
   * 
   * @param idTutor identificador en base de datos
   * @return nos regresa un objeto tutor con informacion encapsulada
   */
  public Tutor obtenerTutor(Long idTutor);
  /**
   * 
   * @param tutor objeto tutor
   * @return true/false nos afirma si un objeto se guardo en base de datos
   */
  public boolean guardarTutor(Tutor tutor);
  
  /**
   * 
   * @param tutor Rescibe un objeto tutor
   * @return nos confirma si fue alamacenada la actualizacion de el objeto
   */
  public boolean actualizarTutor(Tutor tutor);
  
  /**
   * 
   * @param idTutor identificador en base de datos
   * @return nos confirma la eliminacion de un objeto
   */
  public boolean eliminarTutor(Long idTutor);
  
  /**
   * 
   * @return nos regresa una lista con toda la infromacion en base de datos
   */
  public List<Tutor> obtenerTutores();
  
}
