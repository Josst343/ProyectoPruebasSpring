package mx.com.guarderia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tutor extends Familiar {
  private String correo;
  private String numCuentaBancaria;
  
  /**
   * 
   * @return String correo
   */
  public String getCorreo() {
    return correo;
  }
  
  /**
   * 
   * @param correo correo
   */
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  /**
   * 
   * @return String numero de cuenta bancaria.
   */
  public String getNumCuentaBancaria() {
    return numCuentaBancaria;
  }

  /**
   * 
   * @param numCuentaBancaria el numero de la cuenta bancaria de un tutor.
   */
  public void setNumCuentaBancaria(String numCuentaBancaria) {
    this.numCuentaBancaria = numCuentaBancaria;
  }
  
  
}
