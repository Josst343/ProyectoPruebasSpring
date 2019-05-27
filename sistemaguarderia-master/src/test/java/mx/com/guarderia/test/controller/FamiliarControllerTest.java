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
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.service.InfanteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class FamiliarControllerTest {
  private static final Logger LOG = LogManager.getLogger(TutorControllerTest.class);
  @Autowired
  private MockMvc mvc;
  @Autowired
  private InfanteService infanteService;

  /**
   * 
   * 
   * @throws Exception cacha exepciones
   */
  @Test
  public void testGuardaTutor() throws Exception {
    LOG.debug("Entrando a testGuardaTutor");
    try {
      Infante infante=new Infante();
      infante.setNombre("Ana");
      infante.setNombre("Masquez");
      infanteService.guardarInfante(infante);
      mvc.perform(post("/familiar/registrar")
          .param("idInfante", infante.getMatricula()+"")
          .param("nombre","Juan")
          .param("apellidos", "Perez")).andExpect(redirectedUrl("/"));
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
      MvcResult res = mvc.perform(get("/registrarFamiliar")).andReturn();
      Assert.assertEquals("registrarFamiliar", res.getModelAndView().getViewName());
    } catch (Exception e) {
      Assert.fail();
      e.printStackTrace();
    }
  }

}
