package mx.com.guarderia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Familiar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String apellidos;
  private String direccion;
  private String telefono;
  private String curp;
  
  /**
   * 
   * @return Long id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * 
   * @param id identificador
   */
  public void setId(Long id) {
    this.id = id;
  }
  
  /**
   * 
   * @return String nombre
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * 
   * @param nombre nombre del familiar
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  /**
   * 
   * @return String apellidos
   */
  public String getApellidos() {
    return apellidos;
  }
  
  /**
   * 
   * @param apellidos apellidos
   */
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
  
  /**
   * 
   * @return String direccion
   */
  public String getDireccion() {
    return direccion;
  }
  
  /**
   * 
   * @param direccion string
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  /**
   * 
   * @return String telefono
   */
  public String getTelefono() {
    return telefono;
  }
  
  /**
   * 
   * @param telefono String
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  /**
   * 
   * @return String curp
   */
  public String getCurp() {
    return curp;
  }
  
  /**
   * 
   * @param curp String
   */
  public void setCurp(String curp) {
    this.curp = curp;
  }
  
}
