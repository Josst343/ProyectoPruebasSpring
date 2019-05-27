package mx.com.guarderia.test.domain;

import mx.com.guarderia.Application;
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.repository.TutorRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)  
public class TutorTest {
  private Logger log = LogManager.getLogger(TutorTest.class);
  @Autowired
  private TutorRepository tutorRepository;
  /**
   * test para verificar el guardado en db de un tutor
   */
  @Test
  public void testGuardarTutor() {
    log.debug("Entrando al test guardarTutor");
    Tutor tutor = new Tutor();
    tutor.setNombre("Luis");
    tutor.setApellidos("Ramirez");
    tutor.setCorreo("luis@uacm.edu.mx");
    
    tutorRepository.save(tutor);
    Assert.assertNotNull(tutor.getId());
  }
  /**
   * test para actualizar un tutor
   */
  @Test
  public void testActualizarTutor() {
    log.debug("Entrando al testActualizarTutor");
    Tutor tutor = new Tutor();
    Tutor tutorActual;
    tutor.setNombre("Luis");
    tutor.setApellidos("Ramirez");
    tutor.setCorreo("luis@uacm.edu.mx");
    tutorRepository.save(tutor);
    tutor.setNombre("David");
    tutorRepository.save(tutor);
    tutorActual= tutorRepository.findById(tutor.getId()).orElse(null);
    Assert.assertEquals("David", tutorActual.getNombre());
    
  }
  /**
   * test para eliminar un tutor
   */
  public void testEliminarTutor() {
    log.debug("Entrando al testEliminarTutor");
    Tutor tutor = new Tutor();
    Tutor tutorActual;
    tutor.setNombre("Luis");
    tutor.setApellidos("Ramirez");
    tutor.setCorreo("luis@uacm.edu.mx");
    tutorRepository.save(tutor);
    tutor.setNombre("David");
    tutorRepository.save(tutor);
    tutorRepository.delete(tutor);
    tutorActual=tutorRepository.findById(tutor.getId()).orElse(null);
    Assert.assertNull(tutorActual);
  }
  
  /**
   * test para obtener un tutor
   */
  public void testObtenerTutor() {
    log.debug("Entrando al testActualizarTutor");
    Tutor tutor = new Tutor();
    Tutor tutorActual;
    tutor.setNombre("Luis");
    tutor.setApellidos("Ramirez");
    tutor.setCorreo("luis@uacm.edu.mx");
    tutorRepository.save(tutor);
    tutor.setNombre("David");
    tutorRepository.save(tutor);
    tutorActual=tutorRepository.findById(tutor.getId()).orElse(null);
    Assert.assertNotNull(tutorActual);
  }
}
