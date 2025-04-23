package co.edu.unbosque.miprimerspring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Clase para manejar solicitudes HTTP externas utilizando la API HttpClient de Java.
 * 
 * <p>Esta clase realiza solicitudes GET a una URL externa, obtiene la respuesta y la procesa en un formato legible 
 * utilizando la biblioteca Gson. Está diseñada para obtener datos de APIs externas en formato JSON.</p>
 * 
 * @author Nicolas Zambrano
 */
public class ExternalHTTPRequestHandler {
    
    // Cliente HTTP para realizar solicitudes.
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)  // Utiliza HTTP/2
            .connectTimeout(Duration.ofSeconds(10))  // Tiempo de espera para la conexión
            .build();

    /**
     * Método principal que realiza una solicitud GET a una URL y muestra el resultado procesado.
     * 
     * @param args Argumentos de línea de comandos (no se usan en este caso).
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud.
     * @throws InterruptedException Si la solicitud es interrumpida.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("//// GET ////");
        String fact = "https://uselessfacts.jpsh.pl/api/v2/facts/random";  // URL de ejemplo
        System.out.println(doGetAndParse(fact));  // Realiza la solicitud y muestra la respuesta procesada
    }

    /**
     * Realiza una solicitud HTTP GET a la URL proporcionada y procesa la respuesta JSON.
     * 
     * @param url La URL a la que se realiza la solicitud GET.
     * @return La respuesta JSON formateada de manera legible.
     */
    public static String doGetAndParse(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))  // Crea la solicitud con la URL proporcionada
                .header("Content-Type", "application/json")  // Define el tipo de contenido
                .build();

        HttpResponse<String> response = null;
        try {
            response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());  // Envía la solicitud y obtiene la respuesta
        } catch (IOException e) {
            e.printStackTrace();  // Maneja errores de entrada/salida
        } catch (InterruptedException e) {
            e.printStackTrace();  // Maneja interrupciones
        }

        System.out.println("status code -> " + response.statusCode());  // Muestra el código de estado de la respuesta
        String uglyJson = response.body();  // Obtiene el cuerpo de la respuesta
        return prettyPrintUsingGson(uglyJson);  // Devuelve el JSON formateado
    }

    /**
     * Formatea un JSON de formato feo a uno legible utilizando Gson.
     * 
     * @param uglyJson El JSON en formato "feo".
     * @return El JSON formateado de manera legible.
     */
    public static String prettyPrintUsingGson(String uglyJson) {
        Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();  // Crea el objeto Gson con formato bonito
        JsonElement jsonElement = JsonParser.parseString(uglyJson);  // Parsea el JSON feo
        String prettyJsonString = gson.toJson(jsonElement);  // Convierte el JSON en formato bonito
        return prettyJsonString;
    }
}
