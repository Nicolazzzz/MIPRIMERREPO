package co.edu.unbosque.miprimerspring.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador que maneja varias rutas para pruebas simples de cálculo y validación de cadenas.
 * Las rutas incluyen operaciones de suma, cálculos de volumenes, validación de cadenas y más.
 * 
 * @author Nicolas Zambrano
 */
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = { "*" })
@Transactional
public class FirstApiController {
    
    /**
     * Lista de groserías colombianas que se utilizarán para la validación de contenido.
     */
    private final String[] groseriasColombianas = {
            "triplehijueputa", "remalparido", "huevon", "mamaguevo", "pajuo",
            "hijueputa", "malparido", "gonorrea", "marica", "careverga", 
            "pendejo", "berraco", "chimba", "paraco", "sapoperro", 
            "gamin", "culo", "mamón", "pirobo", "pelado", 
            "chucha", "cachón", "guarro", "chicharrón", "chulo", 
            "chéchere", "churro", "cachaco", "chimbumbio", "churumbel", 
            "cagada", "carajo", "catre", "chévere", "chorro", 
            "chuspa", "cucho", "culeado", "culiado", "culo e’ puerca", 
            "desgraciado", "estúpido", "fulero", "guache", "guiso", 
            "hijo e’ tigra", "lámpara", "loco", "mamera", "mierda", 
            "mojón", "paila", "pendejada", "perro", "pirobo", 
            "bandeja", "berriondo", "bobo", "boleta", 
            "bolsa", "cachafaz", "cachaco", "cachón", "caco", 
            "cafre", "caliente", "canilla", "carachupa", "carajada", 
            "carángano", "catre", "chambón", "chanda", "changuerri", 
            "charro", "chécheres", "carechimba", "chichipato", "chigüiro", 
            "chimbiloco", "chino", "chismoso", "chocho", "cholo", 
            "chontico", "chorra", "chuchaqui", "chulo", "chupamedias", 
            "cipote", "comegente", "comején", "comemierda", 
            "cotorra", "cuaima", "cucaracho", "culo e’ paja", 
            "desbaratado", "deschavetado", "desgraciado", "diablo", "enguayabado"
    };

    /**
     * Ruta para saludar a una persona por su nombre.
     * @param nombre Nombre de la persona a saludar.
     * @return Saludo personalizado.
     */
    @GetMapping("/saludar")
    public String getSaludar(@RequestParam String nombre) {
        return "Hola " + nombre;
    }

    /**
     * Ruta para calcular la suma de dos números.
     * @param num1 Primer número.
     * @param num2 Segundo número.
     * @return El resultado de la suma de los dos números.
     */
    @GetMapping("/suma")
    public String getSuma(@RequestParam int num1, @RequestParam int num2) {
        return "Resultado de la suma es " + (num1 + num2);
    }

    /**
     * Ruta para saludar a una persona mediante una petición POST.
     * @param nombre Nombre de la persona a saludar.
     * @return Mensaje personalizado.
     */
    @PostMapping("/saludar")
    public String postSaludarPost(@RequestParam String nombre) {
        return "Vamos a rajar a " + nombre;
    }

    /**
     * Ruta para calcular el volumen de un cilindro.
     * @param radio Radio de la base del cilindro.
     * @param altura Altura del cilindro.
     * @return El volumen del cilindro calculado.
     */
    @GetMapping("/vCilindro")
    public String getVolumenCilindro(@RequestParam double radio, @RequestParam double altura) {
        return "el volumen del cilindro es: " + (Math.PI) * (radio * radio) * altura + " cm^3";
    }

    /**
     * Ruta para calcular el volumen de una esfera.
     * @param radio Radio de la esfera.
     * @return El volumen de la esfera calculado.
     */
    @GetMapping("/vEsfera")
    public String getVolumenEsfera(@RequestParam double radio) {
        return "el volumen de la esfera es: " + (4 * Math.PI * (radio * radio * radio)) / 3 + " cm^3";
    }

    /**
     * Ruta para calcular el volumen de un dodecaedro.
     * @param arista Longitud de la arista del dodecaedro.
     * @return El volumen del dodecaedro calculado.
     */
    @GetMapping("/vDodecaedro")
    public String getVolumenDodecaedro(@RequestParam double arista) {
        return "el volumen del dodecaedro es: " + ((15 + (7 * Math.sqrt(5))) * Math.pow(arista, 3)) / 4;
    }

    /**
     * Ruta para contar la cantidad de vocales en una cadena.
     * @param string Cadena en la que se contarán las vocales.
     * @return Cantidad de vocales en la cadena.
     */
    @GetMapping("/cantidadVocales")
    public String getCantidadVocales(@RequestParam String string) {
        int totalVocales = string.replaceAll("[^AEIOUaeiouÁÉÍÓÚáéíóú]", "").length();
        return "la cantidad de vocales en '" + string + "' es de: " + totalVocales;
    }

    /**
     * Ruta para contar la cantidad de veces que aparece la letra 'x' o 'X' en una cadena.
     * @param string Cadena en la que se contará la cantidad de 'x' o 'X'.
     * @return Cantidad de 'x' o 'X' en la cadena.
     */
    @GetMapping("/cantidadDeX")
    public String getCantidadDeX(@RequestParam String string) {
        int totalX = string.replaceAll("[^xX]", "").length();
        return "la cantidad de x y X en '" + string + "' es de: " + totalX;
    }

    /**
     * Ruta para contar la cantidad de espacios en blanco en una cadena.
     * @param string Cadena en la que se contará la cantidad de espacios.
     * @return Cantidad de espacios en la cadena.
     */
    @GetMapping("/cantidadEspacios")
    public String getCantidadEspacios(@RequestParam String string) {
        String nueva = string.replaceAll("[ ]", "1");
        int total = nueva.replaceAll("[^1]", "").length();
        return "la cantidad de espacios en '" + string + "' es: " + total;
    }

    /**
     * Ruta para contar la cantidad de groserías colombianas en una cadena.
     * @param string Cadena en la que se buscarán las groserías.
     * @return Cantidad de groserías encontradas.
     */
    @GetMapping("/cantidadGroserias")
    public String getCantidadGroserias(@RequestParam String string) {
        int contador = 0;
        String[] palabras = string.toLowerCase().split("\\s+");

        for (String palabra : palabras) {
            for (String groseria : groseriasColombianas) {
                if (palabra.equals(groseria)) {
                    contador++;
                }
            }
        }
        
        return "La cantidad de groserías en '" + string + "' es de: " + contador;
    }

    /**
     * Ruta para verificar si un nombre es válido según ciertos criterios.
     * @param nombre Nombre que se quiere verificar.
     * @return Si el nombre es válido o no.
     */
    @GetMapping("/verificarNombre")
    public String verificarNombreValido(@RequestParam String nombre) {
        boolean esValido = true;
        String[] caracteres = nombre.split("");
        String[] palabrasProhibidas = {"admin", "root", "sistema", "moderador", "test"};
        
        if (nombre.isEmpty()) {
            esValido = false;
        }
        
        for (String caracter : caracteres) {
            if (!Character.isLetter(caracter.charAt(0)) && !caracter.equals(" ")) {
                esValido = false;
            }
        }
        
        for (String palabraSucia : palabrasProhibidas) {
            if (nombre.toLowerCase().contains(palabraSucia)) {
                esValido = false;
            }
        }
        
        return "El nombre '" + nombre + "' es: " + (esValido ? "válido" : "inválido");
    }

    /**
     * Ruta para verificar si un correo electrónico es válido.
     * @param email Correo electrónico que se quiere verificar.
     * @return Si el correo electrónico es válido o no.
     */
    @GetMapping("/verificarEmail")
    public String verificarEmailValido(@RequestParam String email) {
        if (email == null || email.isEmpty()) {
            return "El correo electrónico '" + email + "' es: inválido";
        }

        // Validar formato general usando una expresión regular básica
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        boolean esValido = email.matches(regex);

        return "El correo electrónico '" + email + "' es: " + (esValido ? "válido" : "inválido");
    }

    /**
     * Ruta para verificar si un país existe en el mundo.
     * @param pais Nombre del país que se quiere verificar.
     * @return Si el país existe o no.
     */
    @GetMapping("/verificarPais")
    public String verificarPaisExistente(@RequestParam String pais) {
        boolean existe = false;
        String[] paisesMundiales = {
            "afganistán", "albania", "alemania", "andorra", "angola", "antigua y barbuda", 
            "arabia saudita", "argelia", "argentina", "armenia", "australia", "austria", 
            "azerbaiyán", "bahamas", "bangladés", "barbados", "baréin", "bélgica", "belice", 
            "benín", "bielorrusia", "birmania", "bolivia", "bosnia y herzegovina", "botsuana", 
            "brasil", "brunéi", "bulgaria", "burkina faso", "burundi", "bután", "cabo verde", 
            "camboya", "camerún", "canadá", "catar", "chad", "chile", "china", "chipre", 
            "ciudad del vaticano", "colombia", "comoras", "corea del norte", "corea del sur", 
            "costa de marfil", "costa rica", "croacia", "cuba", "dinamarca", "dominica", 
            "ecuador", "egipto", "el salvador", "emiratos árabes unidos", "eritrea", "eslovaquia", 
            "eslovenia", "españa", "estados unidos", "estonia", "etiopía", "filipinas", 
            "finlandia", "fiyi", "francia", "gabón", "gambia", "georgia", "ghana", "granada", 
            "grecia", "guatemala", "guyana", "guinea", "guinea ecuatorial", "guinea-bisáu", 
            "haití", "honduras", "hungría", "india", "indonesia", "irak", "irán", "irlanda", 
            "islandia", "islas marshall", "islas salomón", "israel", "italia", "jamaica", 
            "japón", "jordania", "kazajistán", "kenia", "kirguistán", "kiribati", "kuwait", 
            "laos", "lesoto", "letonia", "líbano", "liberia", "libia", "liechtenstein", 
            "lituania", "luxemburgo", "macedonia del norte", "madagascar", "malasia", 
            "malaui", "maldivas", "malí", "malta", "marruecos", "mauricio", "mauritania", 
            "méxico", "micronesia", "moldavia", "mónaco", "mongolia", "montenegro", 
            "mozambique", "namibia", "nauru", "nepal", "nicaragua", "níger", "nigeria", 
            "noruega", "nueva zelanda", "omán", "países bajos", "pakistán", "palaos", 
            "palestina", "panamá", "papúa nueva guinea", "paraguay", "perú", "polonia", 
            "portugal", "reino unido", "república centroafricana", "república checa", 
            "república del congo", "república democrática del congo", "república dominicana", 
            "ruanda", "rumania", "rusia", "samoa", "san cristóbal y nieves", "san marino", 
            "san vicente y las granadinas", "santa lucía", "santo tomé y príncipe", "senegal", 
            "serbia", "seychelles", "sierra leona", "singapur", "siria", "somalia", 
            "sri lanka", "suazilandia", "sudáfrica", "sudán", "sudán del sur", "suecia", 
            "suiza", "surinam", "tailandia", "tanzania", "tayikistán", "timor oriental", 
            "togo", "tonga", "trinidad y tobago", "túnez", "turkmenistán", "turquía", 
            "tuvalu", "ucrania", "uganda", "uruguay", "uzbekistán", "vanuatu", "venezuela", 
            "vietnam", "yemen", "yibuti", "zambia", "zimbabue"
        };
        
        String paisNormalizado = pais.toLowerCase().trim();
        
        for (String paisMundial : paisesMundiales) {
            if (paisNormalizado.equals(paisMundial)) {
                existe = true;
                break;
            }
        }
        
        return "El país '" + pais + "' es: " + (existe ? "existente" : "no existente");
    }
}
