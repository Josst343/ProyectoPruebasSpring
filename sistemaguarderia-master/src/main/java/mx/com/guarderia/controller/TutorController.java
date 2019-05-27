package mx.com.guarderia.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.service.TutorService;

@Controller
@SessionAttributes("tutor")

@RequestMapping("/")
public class TutorController {
  private static final Logger LOG = LogManager.getLogger(TutorController.class);
  @Autowired
  private TutorService tutorService;
  /**
   * 
   * @return String nombre de una vista
   */
  @GetMapping("/registrarTutor")
  public String enviarVistaRegistroTutor() {
    return "registrarTutor";
  }
  /**
   * 
   * @param model objeto que permite "añadir atributos a la vista"
   * @param tutor Objeto Tutor
   * @return String nombre de la vista
   */
  @PostMapping("/tutor/registrar")
  public String guardarTutor(Model model,Tutor tutor) {
    LOG.debug("Guardando el tutor: "+tutor);
    tutorService.guardarTutor(tutor);
    model.addAttribute("tutor",tutor);
    return "redirect:/";
  }
}
