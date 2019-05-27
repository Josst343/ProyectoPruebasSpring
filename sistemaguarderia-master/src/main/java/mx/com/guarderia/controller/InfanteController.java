package mx.com.guarderia.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mx.com.guarderia.domain.Alergia;
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.service.AlergiaService;
import mx.com.guarderia.service.InfanteService;
import mx.com.guarderia.service.TutorService;

@Controller
@SessionAttributes("tutor")
@RequestMapping("/")
public class InfanteController {
  private static final Logger LOG = LogManager.getLogger(InfanteController.class);
  @Autowired
  private InfanteService infanteService;
  @Autowired
  private TutorService tutorService;
  @Autowired
  private AlergiaService alergiaService;
  @Autowired
  private HttpSession httpSession;
  /**
   * 
   * @param model modelo de la vista
   * @return String nombre de la vista a devolver
   */
  @GetMapping("/")
  public String mostrarInfantes(Model model) {
    ArrayList<Infante> infantes=(ArrayList<Infante>) infanteService.obtenerInfantes();
    model.addAttribute("infantes",infantes);
    model.addAttribute("numInfantes",125);
    model.addAttribute("tutor",new Tutor());
    model.addAttribute("fechaDeHoy",new Date());
    return "index";
  }
  /**
   * 
   * @param model Model
   * @return String nombre de la vista a devolver
   */
  @GetMapping("/agregarInfante")
  public String registrarInfante(Model model) {
    ArrayList<Tutor> tutores= (ArrayList<Tutor>) tutorService.obtenerTutores();
    model.addAttribute("tutores",tutores);
    if(tutores.size()>0)
      System.out.println("valor de id: "+tutores.get(0).getId());
    model.addAttribute("noHayTutores",tutores.size()==0);
    return "agregarInfante";
  }
  /**
   * @param model Model
   * @param idTutor Objeto de tipo Long que indentifica a un tutor
   * @param infante objeto de tipo Infante
   * @param fechaNac fecha de tipo String
   * @param cadAlergias String que contiene cadenas de alergias separadas por una coma
   * @return String nombre de la vista a devolver
   */
  @PostMapping("/infante/registrar")
  public String agregarInfante(Model model,Long idTutor, Infante infante,String fechaNac,String cadAlergias) {
    Tutor tutor;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("id: "+idTutor);
    if(idTutor != -1) {
      try {
        tutor=tutorService.obtenerTutor(idTutor);
        infante.setTutor(tutor);
        infante.setFechaIngreso(new Date());
        infante.setFechaNacimiento(formato.parse(fechaNac));
        String[] cadenas=cadAlergias.split(",");
        Alergia alergia;
        for(String c: cadenas) {
          alergia=new Alergia(c);
          alergiaService.guardarAlergia(alergia);
          infante.agregarAlergia(alergia);
        }
        infanteService.guardarInfante(infante);
        httpSession.removeAttribute("msmError");
        return "redirect:/";
      }catch (ParseException e) {
        e.printStackTrace();
        LOG.warn("Error en parseo de fechas");
        return "redirect:/agregarInfante";
      }
    }
    httpSession.setAttribute("msmError", true);
    httpSession.setAttribute("msm", "Error: Se debe de seleccionar un tutor");
   
    return "redirect:/agregarInfante";
  }
}
