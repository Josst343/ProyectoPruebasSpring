package mx.com.guarderia.test.domain;

import mx.com.guarderia.Application;
import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.repository.FamiliarRepository;

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
public class FamiliarTest {
  private Logger log = LogManager.getLogger(FamiliarTest.class);
  @Autowired
  private FamiliarRepository familiarRepository;
  
  /**
   * test para guardar un familiar en BD
   */
  @Test
  public void testGuardarFamiliar() {
    log.debug("Entrando al testGuardaFamiliar");
    Familiar familiar = new Familiar();
    familiar.setNombre("Juan");
    familiar.setApellidos("Perez");
    familiar.setDireccion("Al final del mundo a la derecha");
    familiar.setCurp("No aplica");
    familiar.setTelefono("5525669812");
    familiar.setDireccion("Colonia ajusco");
    
    familiarRepository.save(familiar);
    Assert.assertNotNull(familiar.getId());
  }
 /**
  * test para actualizar un familiar
  */
  @Test
  public void testActualizarFamiliar() {
   log.debug("Entrando al testActualizarFamiliar");
   Familiar familiar = new Familiar();
   Familiar familiarActual;
   familiar.setNombre("Juan");
   familiar.setApellidos("Perez");
   familiar.setDireccion("Al final del mundo a la derecha");
   familiar.setCurp("No aplica");
   familiarRepository.save(familiar);
   
   familiar.setNombre("Epifanio");
   familiarRepository.save(familiar);
   familiarActual= familiarRepository.findById(familiar.getId()).orElse(null);
   Assert.assertEquals("Epifanio", familiarActual.getNombre());
   
  }
  /**
   * test para eliminar un familiar
   */
  @Test
  public void testEliminarFamiliar() {
    log.debug("Entrando al testEliminarFamiliar");
    Familiar familiar = new Familiar();
    Familiar familiarActual;
    familiar.setNombre("Rene");
    familiar.setApellidos("Perez");
    familiar.setDireccion("Al final del mundo a la derecha");
    familiar.setCurp("No aplica");
    familiarRepository.save(familiar);
    
    familiarRepository.delete(familiar);
    familiarActual=familiarRepository.findById(familiar.getId()).orElse(null);
    Assert.assertNull(familiarActual);
  }
  /**
   * test para obtener un familiar
   */
  @Test
  public void testObtenerFamiliar() {
    log.debug("Entrando al testObtenerFamiliar");
    Familiar familiar = new Familiar();
    Familiar familiarActual;
    familiar.setNombre("Juan");
    familiar.setApellidos("Perez");
    familiar.setDireccion("calle once");
    familiar.setCurp("No aplica");
    familiar.setTelefono("5525669812");
    familiarRepository.save(familiar);
    
    familiarActual=familiarRepository.findById(familiar.getId()).orElse(null);
    Assert.assertNotNull(familiarActual);
    Assert.assertEquals("Juan", familiarActual.getNombre());
    Assert.assertEquals("Perez", familiarActual.getApellidos());
    Assert.assertEquals("calle once", familiarActual.getDireccion());
    Assert.assertEquals("No aplica", familiarActual.getCurp());
    Assert.assertEquals("5525669812", familiarActual.getTelefono());
    
  }
}
