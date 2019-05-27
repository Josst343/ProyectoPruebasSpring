package mx.com.guarderia.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
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
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.service.TutorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class InfanteControllerTest {
  private static final Logger LOG = LogManager.getLogger(InfanteControllerTest.class);

  @Autowired
  private MockMvc mvc;
  @Autowired
  private TutorService tutorService;
  

  /**
   * Test para registrar un infante usando el controlador
   */
  @Test
  public void testRegistraInfante(){
    LOG.debug("Entrando a testAgregarInfante");
    try {
      MvcResult respuesta=mvc.perform(get("/agregarInfante")).andReturn();
      Assert.assertEquals("agregarInfante", respuesta.getModelAndView().getViewName());
      
    } catch (Exception e) {
      Assert.fail();
      e.printStackTrace();
    }
  }

  /**
   * test para el controlador que muestra un infante
   */
  @Test
  public void testRegistrarInfante() {
    Infante infante;
    LOG.debug("Entrando a testMostrarInfante");
    try {
      Tutor tutor=new Tutor();
      tutor.setNombre("David");
      tutor.setApellidos("Ramires");
      tutorService.guardarTutor(tutor);
      mvc.perform(post("/infante/registrar").param("idTutor", tutor.getId()+"")
          .param("nombre", "Pedro").param("apellidos", "Lopez Vasques")
          .param("fechaNac", "2014-06-2")
          .param("cadAlergias", "parcetamol")).andExpect(redirectedUrl("/"));

    } catch (Exception e) {
      Assert.fail();
      e.printStackTrace();
    }
  }
  /**
   * Test para mostrar la página de inicio
   */
  @Test
  public void testMostrarInfante() {
    try {
      MvcResult resultado=mvc.perform(get("/")).andReturn();
      Assert.assertEquals("index", resultado.getModelAndView().getViewName());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
