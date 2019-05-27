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
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.service.TutorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TutorServiceImplTest {
  private Logger log = LogManager.getLogger(TutorServiceImplTest.class);
  @Autowired
  private TutorService tutorService;

  /**
   * test para confirmar el guardado de un tutor en BD
   */
  @Test
  public void testguardarTutor() {
    Tutor tutor = new Tutor();
    tutor.setNombre("Pablo");
    tutor.setApellidos("Hernandez Juarez");
    tutor.setCorreo("pablo123@gmail.com");
    tutor.setCurp("CABP940101MDFMRR02");
    tutor.setDireccion("lomas estrellas");
    tutor.setNumCuentaBancaria("4598657451");
    tutor.setTelefono("5518497851");
    Assert.assertNotNull(tutor);
    Assert.assertTrue(tutorService.guardarTutor(tutor));
  }

  /**
   * test para confirmar la extraccion de un tuttor en BD
   */
  @Test
  public void testObtenerTurtor() {
    Tutor tutor = new Tutor();
    //tutor.setId(new Long(1));
    tutor.setNombre("Pablo");
    tutor.setApellidos("Hernandez Juarez");
    tutor.setCorreo("pablo123@gmail.com");
    tutor.setCurp("CABP940101MDFMRR02");
    tutor.setDireccion("lomas estrellas");
    tutor.setNumCuentaBancaria("4598657451");
    tutor.setTelefono("5518497851");
    Tutor tutor2 = new Tutor();
    tutor2.setNombre("Marta");
    tutor2.setApellidos("Lopez Juarez");
    tutor2.setCorreo("martita@gmail.com");
    tutor2.setCurp("CABP940101MDFMRR02");
    tutor2.setDireccion("lomas estrellas");
    tutor2.setNumCuentaBancaria("4598657451");
    tutor2.setTelefono("5518497851");
    tutorService.guardarTutor(tutor);
    tutorService.guardarTutor(tutor2);
    Tutor aux = tutorService.obtenerTutor(tutor2.getId());
    Assert.assertNotNull(aux);
    Assert.assertEquals("Marta", aux.getNombre());
  }

  /**
   * 
   */
  @Test
  public void testActualizarTutor() {
    Tutor tutor = new Tutor();
    tutor.setNombre("Pablo");
    tutor.setApellidos("Hernandez Juarez");
    tutor.setCorreo("pablo123@gmail.com");
    tutor.setCurp("CABP940101MDFMRR02");
    tutor.setDireccion("lomas estrellas");
    tutor.setNumCuentaBancaria("4598657451");
    tutor.setTelefono("5518497851");
    tutorService.guardarTutor(tutor);
    Tutor aux = tutorService.obtenerTutor(tutor.getId());
    Assert.assertNotNull(aux);
    aux.setApellidos("Lopez Mateo");
    Assert.assertTrue(tutorService.actualizarTutor(aux));
  }

  /**
   * Test para borrar un tutor de la BD
   */
  @Test
  public void testEliminarTutor() {
    Tutor tutor = new Tutor();
    //tutor.setId(new Long(1));
    tutor.setNombre("Pablo");
    tutor.setApellidos("Hernandez Juarez");
    tutor.setCorreo("pablo123@gmail.com");
    tutor.setCurp("CABP940101MDFMRR02");
    tutor.setDireccion("lomas estrellas");
    tutor.setNumCuentaBancaria("4598657451");
    tutor.setTelefono("5518497851");
    Assert.assertNotNull(tutor);
    tutorService.guardarTutor(tutor);
    Assert.assertTrue(tutorService.eliminarTutor(tutor.getId()));
  }

  /**
   * test para obtener todos los tutores de la BD
   */
  @Test
  public void testObtenerTutores() {
    Tutor tutor = new Tutor();
    tutor.setNombre("Pablo");
    tutor.setApellidos("Hernandez Juarez");
    tutor.setCorreo("pablo123@gmail.com");
    tutor.setCurp("CABP940101MDFMRR02");
    tutor.setDireccion("lomas estrellas");
    tutor.setNumCuentaBancaria("4598657451");
    tutor.setTelefono("5518497851");
    Tutor tutor2 = new Tutor();
    tutor2.setNombre("Marta");
    tutor2.setApellidos("Lopez Juarez");
    tutor2.setCorreo("martita@gmail.com");
    tutor2.setCurp("CABP940101MDFMRR02");
    tutor2.setDireccion("lomas estrellas");
    tutor2.setNumCuentaBancaria("4598657451");
    tutor2.setTelefono("5518497851");
    Assert.assertNotNull(tutor);
    Assert.assertNotNull(tutor2);
    tutorService.guardarTutor(tutor);
    tutorService.guardarTutor(tutor2);
    Assert.assertTrue(tutorService.obtenerTutores().size() > 1);
  }
}
