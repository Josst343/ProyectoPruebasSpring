package mx.com.guarderia;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Clase para la configuracion del MVC
 * @author luis david
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/webjars/**").addResourceLocations(
         "classpath:/META-INF/resources/webjars/");
  }
}
