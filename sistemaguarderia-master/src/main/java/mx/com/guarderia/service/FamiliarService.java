package mx.com.guarderia.service;

import mx.com.guarderia.domain.Familiar;

import org.springframework.stereotype.Service;



@Service
public interface FamiliarService {
  /**
   * 
   * @param familiar objeto Familiar
   * @return boolean true or false
   */
  public boolean guardarFamiliar(Familiar familiar);
  
  /**
   * 
   * @param familiar objeto Familiar a actualizar
   * @return boolean true or false
   */
  public boolean actualizarFamiliar(Familiar familiar);
  
  /**
   * 
   * @param idFamiliar indentificar de un familiar de tipo Long
   * @return boolean true or false
   */
  public boolean eliminarFamiliar(Long idFamiliar);
  
  /**
   * 
   * @param idFamiliar indentificar de un familiar de tipo Long
   * @return Familiar familiar de un infante
   */
  public Familiar obtenerFamiliar(Long idFamiliar);
}
