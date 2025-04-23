package co.edu.unbosque.miprimerspring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase de inicialización para despliegues en un contenedor servlet tradicional (como Tomcat externo).
 * 
 * Esta clase permite configurar la aplicación cuando se despliega como un archivo WAR, en lugar de un JAR autoejecutable.
 * Extiende {@link SpringBootServletInitializer} para facilitar dicha configuración.
 * 
 * @author Nicolás Zambrano
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configura la aplicación al desplegarla en un contenedor servlet externo.
     * 
     * @param application el builder de la aplicación Spring
     * @return el builder configurado con la clase principal {@link MiprimerspringApplication}
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MiprimerspringApplication.class);
    }
}
