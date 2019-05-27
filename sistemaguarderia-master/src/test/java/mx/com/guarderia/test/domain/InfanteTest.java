package mx.com.guarderia.test.domain;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.guarderia.Application;
import mx.com.guarderia.domain.Alergia;
import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.repository.AlergiaRepository;
import mx.com.guarderia.repository.FamiliarRepository;
import mx.com.guarderia.repository.InfanteRepository;
import mx.com.guarderia.repository.TutorRepository;





@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class InfanteTest {
  private Logger log = LogManager.getLogger(InfanteTest.class);
  @Autowired
  private InfanteRepository infanteRepository;
  @Autowired
  private TutorRepository tutorRepository;
  @Autowired
  private FamiliarRepository familiarRepository;
  @Autowired
  private AlergiaRepository alergiaRepository;
  /**
   * test para verificar guardado de un infante en BD
   */
  @Test
  public void testGuardaInfante() {
    log.debug("Se esta por ejecutar el testGuardarInfante");
    Infante infante = new Infante();
    infante.setNombre("Juanito");
    infante.setApellidos("Perez");
    infante.setFechaBaja(new Date());
    infante.setFechaNacimiento(new Date());
    infante.setFechaBaja(new Date());
    Tutor t = new Tutor();
    Familiar f=new Familiar();
    Alergia a= new Alergia("paracetamol");
    f.setNombre("Pablo");
    t.setNombre("Juan");
    familiarRepository.save(f);
    tutorRepository.save(t);
    alergiaRepository.save(a);
    infante.agregarFamiliar(f);
    infante.setTutor(t);
    infante.agregarAlergia(a);
    
    infanteRepository.save(infante);
    Assert.assertNotNull(infante.getMatricula());
  }
  /**
   * test para actualizar infante
   */
  @Test
  public void testActualizarInfante() {
    log.debug("Se esta por ejecutar el testActualizarInfante");
    Infante infante = new Infante();
    Infante infanteActual;
    infante.setNombre("Juanito");
    infante.setApellidos("Perez");
    infante.setFechaBaja(new Date());
    infante.setFechaNacimiento(new Date());
    infante.setFechaBaja(new Date());
    infanteRepository.save(infante);
    infante.setApellidos("Ramirez");
    infanteRepository.save(infante);
    infanteActual=infanteRepository.findById(infante.getMatricula()).orElse(null);
    Assert.assertEquals("Ramirez", infanteActual.getApellidos());
  }
  
  /**
   * test para eliminar un infante
   */
  @Test
  public void testEliminarInfante() {
    log.debug("Se esta por ejecutar el testEliminarInfante");
    Infante infante = new Infante();
    Infante infanteActual;
    infante.setNombre("Juanito");
    infante.setApellidos("Perez");
    infanteRepository.save(infante);
    infanteRepository.delete(infante);
    infanteActual=infanteRepository.findById(infante.getMatricula()).orElse(null);
    Assert.assertNull(infanteActual);
  }
  
  /**
   * test para obtener un infante
   */
  public void testObtenerInfante() {
    log.debug("Se esta por ejecutar el testActualizarInfante");
    Infante infante = new Infante();
    Infante infanteActual;
    Date fb=new Date();
    Date fi=new Date();
    Date fn=new Date();
    infante.setNombre("Juanito");
    infante.setApellidos("Perez");
    infante.setFechaBaja(fb);
    infante.setFechaNacimiento(fn);
    infante.setFechaIngreso(fi);
    infanteRepository.save(infante);
    
    infanteActual=infanteRepository.findById(infante.getMatricula()).orElse(null);
    Assert.assertNotNull(infanteActual);
    Assert.assertEquals("Juanito", infanteActual.getNombre());
    Assert.assertEquals("Perez", infanteActual.getApellidos());
    Assert.assertEquals(fi, infanteActual.getFechaIngreso());
    Assert.assertEquals(fn, infanteActual.getFechaNacimiento());
    Assert.assertEquals(fb, infanteActual.getFechaBaja());
  }
}
