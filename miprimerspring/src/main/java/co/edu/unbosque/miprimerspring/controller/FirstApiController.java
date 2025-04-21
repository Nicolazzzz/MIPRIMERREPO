package co.edu.unbosque.miprimerspring.controller;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = { "*" })
@Transactional
public class FirstApiController {
	
	
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

	@GetMapping("/saludar")
	public String getSaludar(@RequestParam String nombre) {
		return "Hola " + nombre;
	}

	@GetMapping("/suma")
	public String getSuma(@RequestParam int num1, @RequestParam int num2) {
		return "Resultado de la suma es " + (num1 + num2);
	}

	@PostMapping("/saludar")
	public String postSaludarPost(@RequestParam String nombre) {

		return "Vamos a rajar a " + nombre;
	}

	@GetMapping("/vCilindro")
	public String getVolumenCilindro(@RequestParam double radio, @RequestParam double altura) {
		return "el volumen del cilndro es: " + (Math.PI) * (radio * radio) * altura + " cm^3";
	}

	@GetMapping("/vEsfera")
	public String getVolumenEsfera(@RequestParam double radio) {
		return "el volumen de la esfera es: " + (4 * Math.PI * (radio * radio * radio)) / 3 + " cm^3";
	}

	@GetMapping("/vDodecaedro")
	public String getVolumenDodecaedro(@RequestParam double arista) {
		return "el volumen del dodecaedro es: " + ((15 + (7 * Math.sqrt(5))) * Math.pow(arista, 3)) / 4;
	}

	@GetMapping("/cantidadVocales")
	public String getCantidadVocales(@RequestParam String string) {
		int totalVocales = string.replaceAll("[^AEIOUaeiouÁÉÍÓÚáéíóú]", "").length();
		return "la cantidad de vocales en '" + string + "' es de: " + totalVocales;
	}
	
	@GetMapping("/cantidadDeX")
	public String getCantidadDeX(@RequestParam String string) {
		int totalX = string.replaceAll("[^xX]", "").length();
		return "la cantidad de x y X en '"+string+"' es de: "+ totalX;
	}
	
	@GetMapping("/cantidadEspacios")
	public String getCantidadEspacios(@RequestParam String string) {
		String nueva = string.replaceAll("[ ]", "1");
		int total = nueva.replaceAll("[^1]", "").length();
		return "la cantidad de epspacios en '"+string+"' es: "+total;
	}
	

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
    
    @GetMapping("/verificarEmail")
    public String verificarEmailValido(@RequestParam String email) {
        boolean esValido = true;
        int contador = 0;
        
        if (email.isEmpty()) {
            esValido = false;
        }
        
        if (!email.contains("@")) {
            esValido = false;
        }
        
        String[] partes = email.split("@");
        if (partes.length != 2) {
            esValido = false;
        } else {
            String nombreUsuario = partes[0];
            String dominio = partes[1];
            
            if (nombreUsuario.isEmpty() || dominio.isEmpty()) {
                esValido = false;
            }
            
            if (!dominio.contains(".")) {
                esValido = false;
            }
            
            String[] parteDominio = dominio.split("\\.");
            if (parteDominio.length < 2 || parteDominio[parteDominio.length-1].isEmpty()) {
                esValido = false;
            }
            
            for (char c : email.toCharArray()) {
                if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '_' && c != '-') {
                    esValido = false;
                }
            }
        }
        
        return "El correo electrónico '" + email + "' es: " + (esValido ? "válido" : "inválido");
    }
    
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
