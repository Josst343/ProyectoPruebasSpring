package mx.com.guarderia.test.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import mx.com.guarderia.domain.Familiar;
import mx.com.guarderia.domain.Infante;
import mx.com.guarderia.domain.Tutor;
import mx.com.guarderia.service.InfanteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class InfanteServiceImplTest {
   private static final Logger LOG = LogManager.getLogger(InfanteServiceImplTest.class);
   @Autowired
   private InfanteService infanteService;
   /**
    * test para confirmar que se guarda la informacion en BD
    * @throws ParseException 
    */
   @Test
   public void testGuardaInfante() throws ParseException  {
   LOG.debug("Entrando test guarda infante");
   Infante infante = new Infante();
   infante.setNombre("Marcos");
   infante.setApellidos("Lopez Martines");
   SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
   infante.setFechaIngreso(sdf2.parse("18-05-2018"));
   infante.setFechaNacimiento(sdf2.parse("22-03-2015"));
   Assert.assertNotNull(infante);
   infanteService.guardarInfante(infante);
   }
   /**
    * test para verificar la actualizacion de los datos de un infante
 * @throws ParseException 
    */
   @Test
   public void testActualizarInfante() throws ParseException {
   LOG.debug("Entranbdo a testActualizaInfante");
   Infante infante = new Infante();   
   infante.setNombre("Marcos");
   infante.setApellidos("Lopez Martines");
   SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
   infante.setFechaIngreso(sdf2.parse("18-05-2018"));
   infante.setFechaNacimiento(sdf2.parse("22-03-2015"));
   infanteService.guardarInfante(infante);
   Infante aux = infanteService.obtenerInfante(new Long(1));
   Assert.assertNotNull(aux);
   aux.setApellidos("Lopez marques");
   Assert.assertTrue(infanteService.actualizarInfante(aux));
   }
   /**
    * test para verificar la eliminacion de un infante
 * @throws ParseException 
    */
   @Test
   public void testEliminarInfante() throws ParseException {
   LOG.debug("Entranbdo a testActualizaInfante");
   Infante infante = new Infante();   
   infante.setNombre("Marcos");
   infante.setApellidos("Lopez Martines");
   SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
   infante.setFechaIngreso(sdf2.parse("18-05-2018"));
   infante.setFechaNacimiento(sdf2.parse("22-03-2015"));
   infanteService.guardarInfante(infante);
   Assert.assertTrue(infanteService.eliminarInfante(new Long(1)));
   }
   /**
    * test para extrar un infante de la base de datos
 * @throws ParseException 
    */
   @Test
   public void testObtenerInfante() throws ParseException {
   LOG.debug("Entrando a testObtenerInfante");
   Infante infante = new Infante();   
   infante.setNombre("Marcos");
   infante.setApellidos("Lopez Martines");
   SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
   infante.setFechaIngreso(sdf2.parse("18-05-2018"));
   infante.setFechaNacimiento(sdf2.parse("22-03-2015"));
   infanteService.guardarInfante(infante);
   Infante aux = infanteService.obtenerInfante(infante.getMatricula());
   Assert.assertEquals("Marcos", aux.getNombre());
   }
}
