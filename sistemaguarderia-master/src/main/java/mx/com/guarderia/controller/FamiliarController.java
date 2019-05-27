package mx.com.guarderia.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.service.FamiliarService;
import mx.com.guarderia.service.InfanteService;

@Controller
@RequestMapping("/")
public class FamiliarController {
  @Autowired
  private HttpSession httpSession;
  
  @Autowired
  private InfanteService infanteService;
  
  @Autowired
  private FamiliarService familiarService;
  /**
   * 
   * @param model Modelo de la vista
   * @return String nombre de la vista
   */
  @GetMapping("/registrarFamiliar")
  public String mostrarVistaRegistroFamiliar(Model model) {
    ArrayList<Infante> infantes = (ArrayList<Infante>) infanteService.obtenerInfantes();
    model.addAttribute("infantes",infantes);
    model.addAttribute("noHayFamiliares",infantes.size()==0);
    return "registrarFamiliar";
  }
  /**
   * 
   * @param model modelo de la vista
   * @param idInfante identificar de un infante
   * @param familiar Objeto de tipo Familiar
   * @return String nombre de la vista
   */
  @PostMapping("/familiar/registrar")
  public String registrarFamiliar(Model model, Long idInfante, Familiar familiar) {
    if(idInfante!=-1) {
      Infante infante= infanteService.obtenerInfante(idInfante);
      familiarService.guardarFamiliar(familiar);
      infante.agregarFamiliar(familiar);
      infanteService.actualizarInfante(infante);
      return "redirect:/";
    }
    httpSession.setAttribute("msmError1", true);
    httpSession.setAttribute("msm1", "Error: Se debe de seleccionar un infante");
    return "redirect:/registrarFamiliar";
  }
}
