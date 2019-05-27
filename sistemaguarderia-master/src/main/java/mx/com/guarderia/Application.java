package mx.com.guarderia;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/** La clase con un solo método estatico para inicializar toda la aplicación web.
 *
 * 
 * @author Luis David
 *
 */

@SpringBootApplication
public class Application {
  
  /**
   * 
   * @param args Argumentos
   */
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
  /**
   * 
   * @return ServletRegistrationBean 
   */
  @Bean
  public ServletRegistrationBean<WebServlet> h2servletRegistration() {
      final ServletRegistrationBean<WebServlet> registration 
        = new ServletRegistrationBean<WebServlet>(new WebServlet());
      registration.addUrlMappings("/console/*");
      return registration;
  }
}
