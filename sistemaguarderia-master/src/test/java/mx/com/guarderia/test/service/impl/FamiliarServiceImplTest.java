package mx.com.guarderia.test.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.guarderia.Application;
import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.service.FamiliarService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class FamiliarServiceImplTest {
  private static final Logger LOG = LogManager.getLogger(FamiliarServiceImplTest.class);
  @Autowired
  private FamiliarService familiarService;

  /**
   * test para probar que un familiar se guarde en BD
   */
  @Test
  public void testGuardaFamiliar() {
    LOG.debug("Entrando a testGuardaFamiliar");
    Familiar familiar = new Familiar();
    familiar.setNombre("Perla");
    familiar.setApellidos("Campos Barajas");
    familiar.setCurp("CABP940101MDFMRR02");
    familiar.setDireccion("Avenida San gregorio #1021");
    familiar.setTelefono("5518542491");
    familiarService.guardarFamiliar(familiar);
    Assert.assertNotNull(familiar);

  }

  /**
   * test para actualizar los atributos de un familiar extraidos de la base de
   * datos y actualizados en la misma
   */
  @Test
  public void testActualizaFamiliar() {
    LOG.debug("Entrando a testActualizaFamilia");
    Familiar familiar = new Familiar();
    //familiar.setId(new Long(1));
    familiar.setNombre("Perla");
    familiar.setApellidos("Campos Barajas");
    familiar.setCurp("CABP940101MDFMRR02");
    familiar.setDireccion("Avenida San gregorio #1021");
    familiar.setTelefono("5518542491");
    Familiar familiar2 = new Familiar();
    //familiar.setId(new Long(2));
    familiar.setNombre("Pedro");
    familiar.setApellidos("Campos Barajas");
    familiar.setCurp("PEBP940101MDFMRR02");
    familiar.setDireccion("Avenida Sanlazaro");
    familiar.setTelefono("5518542491");
    familiarService.guardarFamiliar(familiar);
    familiarService.guardarFamiliar(familiar2);
    Familiar aux = familiarService.obtenerFamiliar(familiar2.getId());
    Assert.assertNotNull(aux);
    aux.setTelefono("5519872401");
    Assert.assertTrue(familiarService.actualizarFamiliar(aux));

  }

  /**
   * test para obtener un familiar BD
   */
  @Test
  public void testObtenerFamiliar() {
    LOG.debug("Entrando a testObtenerFamiliar");
    Familiar familiar = new Familiar();
    //
    //familiar.setId(new Long(1));
    familiar.setNombre("Perla");
    familiar.setApellidos("Campos Barajas");
    familiar.setCurp("CABP940101MDFMRR02");
    familiar.setDireccion("Avenida San gregorio #1021");
    familiar.setTelefono("5518542491");
    Familiar familiar2 = new Familiar();
    //familiar2.setId(new Long(2));
    familiar2.setNombre("Karla");
    familiar2.setApellidos("Campos Morales");
    familiar2.setCurp("CABP940101MDFMRR02");
    familiar2.setDireccion("Avenida San gregorio #1021");
    familiar2.setTelefono("5518542491");
    Assert.assertNotNull(familiar2);
    familiarService.guardarFamiliar(familiar);
    familiarService.guardarFamiliar(familiar2);
    //Cuando guardar un familiar este se actualiza
    //es decir aunque no le pongas un id si se logra guardar
    //el familiar automaticamente se le asignar el Id correspondient al familiar
    Familiar aux = familiarService.obtenerFamiliar(familiar2.getId());
    Assert.assertNotNull(aux);
    Assert.assertEquals("Karla", aux.getNombre());
  }

  /**
   * test para eliminar un familiar de la BD buscado por ID
   */
  @Test
  public void testEliminarFamiliar() {
    LOG.debug("Entrando a testEliminarFamiliar");
    Familiar familiar = new Familiar();
    familiar.setNombre("Perla");
    familiar.setApellidos("Campos Barajas");
    familiar.setCurp("CABP940101MDFMRR02");
    familiar.setDireccion("Avenida San gregorio #1021");
    familiar.setTelefono("5518542491");
    Assert.assertNotNull(familiar);
    familiarService.guardarFamiliar(familiar);
    Assert.assertTrue(familiarService.eliminarFamiliar(familiar.getId()));

  }
}
