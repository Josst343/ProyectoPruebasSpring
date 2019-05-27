package mx.com.guarderia.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Infante {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long matricula;
  private String nombre;
  private String apellidos;
  private Date fechaNacimiento;
  private Date fechaIngreso;
  private Date fechaBaja;
  
  @OneToOne
  private Tutor tutor;
  @OneToMany
  private List<Familiar> familiares; 
  
  @OneToMany
  private List<Alergia> alergias;
  /**
   * Constructor
   */
  public Infante() {
    alergias= new ArrayList<Alergia>();
    familiares= new ArrayList<Familiar>();
  }
  /**
   * 
   * @return Long matricula
   */
  public Long getMatricula() {
    return matricula;
  }
  
  /**
   * 
   * @param matricula Long
   */
  public void setMatricula(Long matricula) {
    this.matricula = matricula;
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
   * @param nombre String
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  /**
   * 
   * @return date fecha de nacimiento
   */
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }
  
  /**
   * 
   * @param fechaNacimiento 
   */
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  /**
   * 
   * @return Date fecha de ingreso
   */
  public Date getFechaIngreso() {
    return fechaIngreso;
  }
  
  /**
   * 
   * @param fechaIngreso 
   */
  public void setFechaIngreso(Date fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }
  
  /**
   * 
   * @return Date fecha de baja
   */
  public Date getFechaBaja() {
    return fechaBaja;
  }
  
  /**
   * 
   * @param fechaBaja 
   */
  public void setFechaBaja(Date fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  /**
   * 
   * @return Tutor tutor
   */
  public Tutor getTutor() {
    return tutor;
  }

  /**
   * 
   * @param tutor Tutor
   */
  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }

  /**
   * 
   * @return List lista de familiares
   */
  public List<Familiar> getFamiliares() {
    return familiares;
  }
  
  /**
   * 
   * @param familiares lista de familiares
   */
  public void setFamiliares(List<Familiar> familiares) {
    this.familiares = familiares;
  }

  /**
   * 
   * @return List lista de alergias
   */
  public List<Alergia> getAlergia() {
    return alergias;
  }

  /**
   * 
   * @param alergias lista de alergias
   */
  public void setAlergia(List<Alergia> alergias) {
    this.alergias = alergias;
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
  * @param apellidos String
  */
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
/**
 * 
 * @return List lista de alergias
 */
  public List<Alergia> getAlergias() {
    return alergias;
  }
/**
 * 
 * @param alergias List<Alergia>
 */
  public void setAlergias(List<Alergia> alergias) {
    this.alergias = alergias;
  }
  /**
   * 
   * @param familiar Objeto de tipo Famliar
   */
  public void agregarFamiliar(Familiar familiar) {
    familiares.add(familiar);
  }
  /**
   * 
   * @param a Objeto de tipo Alergia
   */
  
  public void agregarAlergia(Alergia a) {
    alergias.add(a);
  }
}
