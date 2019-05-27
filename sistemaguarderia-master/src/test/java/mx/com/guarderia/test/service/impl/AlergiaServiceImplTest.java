package mx.com.guarderia.test.service.impl;

import java.util.List;

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
import mx.com.guarderia.service.AlergiaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AlergiaServiceImplTest {
  private static final Logger LOG = LogManager.getLogger(AlergiaServiceImplTest.class);
  @Autowired
  private AlergiaService alergiaService;

  /**
   * Alergia es un objeto que se almacena en base de datos con este test
   * aseguramos que se estan guardando los datos
   */
  @Test
  public void testGuardarAlergia() {
    LOG.debug("entrando a testGuardarAlergia");
    Alergia alergiaPrueba = new Alergia();
    alergiaPrueba.setId(new Long(1));
    alergiaPrueba.setAlergia("pollo");
    alergiaService.guardarAlergia(alergiaPrueba);
    Assert.assertNotNull(alergiaPrueba);
  }

  /**
   * Con un objeto alergia almacenado en BD lo buscamos por id es modificado y es
   * nuevamente alamacenado con el mismo id
   */
  @Test
  public void testActualizaAlergia() {
    LOG.debug("entrando a tesActualizarAlergia");
    Alergia alergia = new Alergia();
    alergia.setAlergia("leche");
    Alergia alergia2 = new Alergia();
    alergia2.setAlergia("pollo");
    alergiaService.guardarAlergia(alergia);
    alergiaService.guardarAlergia(alergia2);
    Alergia aux = alergiaService.obtenerAlergia(alergia2.getId());
    Assert.assertNotNull(aux);
    Assert.assertEquals("pollo", aux.getAlergia());
    aux.setAlergia("huevo");
    Assert.assertTrue(alergiaService.actualizarAlergia(aux));
  }

  /**
   * idAlergia Identificador de tipo Long de una alergia. En este test verificamos
   * que con una alergia almacenada podemos eliminar de la base de datos si el id
   * coincide
   */
  @Test
  public void testEliminaAlergia() {
    LOG.debug("entrando a tesEliminaAlergia");
    Alergia alergiaPrueba = new Alergia();
    alergiaPrueba.setAlergia("pescado");
    alergiaService.guardarAlergia(alergiaPrueba);
    Assert.assertTrue(alergiaService.eliminarAlergia(alergiaPrueba.getId()));
  }

  /**
   * En este test agregamos datos en la base de datos y se recuperan usando el
   * mismo id asignado
   */
  @Test
  public void testObtenerAlergia() {
    LOG.debug("entrando a tesObtenerAlergia");
    Alergia alergia = new Alergia();
    alergia.setAlergia("pollo");
    alergiaService.guardarAlergia(alergia);
    Alergia aux = alergiaService.obtenerAlergia(new Long(1));
    Assert.assertEquals("pollo", aux.getAlergia());

  }

  /**
   * para este este necesitamos alamacenar varios datos en la BD y para obtener
   * todos los datos se crea una lista que contendra estos datos antes guardados
   * regresa lista con las alergias registradas \n
   */
  @Test
  public void testObtenerAlergias() {
    LOG.debug("entrando a tesEliminaAlergias");
    Alergia alergia1 = new Alergia();
    alergia1.setAlergia("pollo");
    Alergia alergia2 = new Alergia();
    alergia2.setAlergia("leche");
    Alergia alergia3 = new Alergia();
    alergia3.setAlergia("huevo");
    alergiaService.guardarAlergia(alergia1);
    alergiaService.guardarAlergia(alergia2);
    alergiaService.guardarAlergia(alergia3);
    List<Alergia> alergias = alergiaService.obtenerAlergias();
    Assert.assertTrue(alergias.size() > 1);
  }
}
