package cat.itb.m9.springboot.exemples.controladors.configuracio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* No fa ni cas, perquè tenim un @Controller prioritari
 *
 */
@Configuration
public class ConfiguracioVistes implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hola").setViewName("hola_xungo.html");
        registry.addViewController("/").setViewName("hola.html");

    }
}
