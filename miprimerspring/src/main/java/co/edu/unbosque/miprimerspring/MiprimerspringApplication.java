package co.edu.unbosque.miprimerspring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Clase principal de la aplicación Spring Boot.
 * 
 * Esta clase sirve como punto de entrada para la ejecución de la aplicación.
 * También define beans que se utilizan a lo largo del contexto de Spring, como el {@link ModelMapper}.
 * 
 * @author Nicolás Zambrano
 */
@SpringBootApplication
public class MiprimerspringApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * 
     * @param args argumentos de la línea de comandos (no se utilizan normalmente)
     */
    public static void main(String[] args) {
        SpringApplication.run(MiprimerspringApplication.class, args);
    }

    /**
     * Crea un bean {@link ModelMapper} para ser utilizado en el contexto de Spring.
     * 
     * Este bean es útil para mapear objetos de una clase a otra, por ejemplo, 
     * de entidades a DTOs (Data Transfer Objects) y viceversa.
     * 
     * @return una instancia nueva de {@link ModelMapper}
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
