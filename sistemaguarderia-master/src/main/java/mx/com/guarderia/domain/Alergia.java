package mx.com.guarderia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alergia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String alergia;
  /**
   * Constructor vacio
   */
  public Alergia() {
    
  }
  /**
   * Constructor 
   * @param n nombre de la alergia
   */
  public Alergia(String n) {
    alergia=n;
  }
  /**
   * 
   * @return id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * 
   * @param id identificador de la alergia
   */
  public void setId(Long id) {
    this.id = id;
  }
  
  /**
   * 
   * @return Alergia
   */
  public String getAlergia() {
    return alergia;
  }
  
  /**
   * 
   * @param alergia nombre de la alergia
   */
  public void setAlergia(String alergia) {
    this.alergia = alergia;
  }
  
  
}
