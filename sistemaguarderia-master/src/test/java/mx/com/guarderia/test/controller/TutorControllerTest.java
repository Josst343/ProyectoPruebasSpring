/*Test para verificar la funcionavilidad
 * de el controlador de la aplicacion 
 * 
 */
package mx.com.guarderia.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import mx.com.guarderia.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TutorControllerTest {
  private static final Logger LOG = LogManager.getLogger(TutorControllerTest.class);
  @Autowired
  private MockMvc mvc;

  /**
   * 
   * 
   * @throws Exception cacha exepciones
   */
  @Test
  public void testGuardaTutor() throws Exception {
    LOG.debug("Entrando a testGuardaTutor");
    try {
      mvc.perform(post("/tutor/registrar")
          .param("nombre","Juan")
          .param("apellidos", "Perez")
          .param("correo", "perla@gmail.com")
          .param("numCuentaBancaria", "201854")).andExpect(redirectedUrl("/"));
    } catch (Exception e) {
      Assert.fail();
      e.printStackTrace();
    }
  }

  /**
   * 
   */
  @Test
  public void testEnviaVistaRegistroTutor() {
    LOG.debug("Entrando a testEnviaVistaRegistroTutor");
    try {
      MvcResult res = mvc.perform(get("/registrarTutor")).andReturn();
      Assert.assertEquals("registrarTutor", res.getModelAndView().getViewName());
    } catch (Exception e) {
      Assert.fail();
      e.printStackTrace();
    }
  }

}
