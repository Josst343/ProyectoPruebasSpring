package mx.com.guarderia.test.domain;

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
import mx.com.guarderia.repository.AlergiaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AlergiaTest {
  private Logger log = LogManager.getLogger(AlergiaTest.class);
  @Autowired
  private AlergiaRepository alergiaRepository;
  /**
   * test para guardar una alergia
   */
  @Test
  public void testGuardarAlergia() {
    log.debug("Entrando al testGuardarAlergia");
    Alergia alergia=new Alergia("paracetamol");
    alergiaRepository.save(alergia);
    Assert.assertNotNull(alergia);
  }
  /**
   * test para actualizar una alergia
   */
  @Test
  public void testActualizarAlergia() {
    log.debug("Entrando al testActualizarAlergia");
    Alergia alergia=new Alergia("paracetamol");
    Alergia alergiaActual;
    alergiaRepository.save(alergia);
    alergia.setAlergia("alergia2");
    alergiaRepository.save(alergia);
    alergiaActual=alergiaRepository.findById(alergia.getId()).orElse(null);
    
    Assert.assertEquals("alergia2", alergiaActual.getAlergia());
  }
  /**
   * test para eliminar una alergia
   */
  @Test
  public void testEliminarAlergia() {
    log.debug("Entrando al testEliminarAlergia");
    Alergia alergia=new Alergia("paracetamol");
    Alergia alergiaActual;
    alergiaRepository.save(alergia);
    alergiaRepository.delete(alergia);
    alergiaActual=alergiaRepository.findById(alergia.getId()).orElse(null);
    
    Assert.assertNull(alergiaActual);
  }
  /**
   * test para obtener una alergia
   */
  @Test
  public void testObtenerAlergia() {
    log.debug("Entrando al testObtenerAlergia");
    Alergia alergia=new Alergia("paracetamol");
    Alergia alergiaActual;
    alergiaRepository.save(alergia);
    alergiaActual=alergiaRepository.findById(alergia.getId()).orElse(null);
    
    Assert.assertNotNull(alergiaActual);
  }
  
}
