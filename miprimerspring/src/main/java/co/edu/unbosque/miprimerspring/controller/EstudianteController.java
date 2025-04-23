package co.edu.unbosque.miprimerspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.service.EstudianteService;

/**
 * Controlador REST para la gestión de estudiantes.
 * 
 * Maneja las operaciones de creación, visualización y eliminación de estudiantes 
 * a través de endpoints HTTP. Hace uso del servicio {@link EstudianteService} 
 * para interactuar con la capa de negocio.
 * 
 * @author Nicolás Zambrano
 */
@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = { "*" })
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteServ;

    /**
     * Constructor por defecto.
     */
    public EstudianteController() {
        super();
    }

    /**
     * Crea un nuevo estudiante a partir de los datos recibidos como parámetros.
     *
     * @param nombre    nombre del estudiante
     * @param documento número de documento
     * @param programa  programa académico
     * @param semestre  semestre actual
     * @return respuesta HTTP con el estado de la operación
     */
    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestParam String nombre,
                                        @RequestParam Integer documento,
                                        @RequestParam String programa,
                                        @RequestParam int semestre) {

        EstudianteDTO nuevoEstudiante = new EstudianteDTO(nombre, documento, programa, semestre);
        int estado = estudianteServ.create(nuevoEstudiante);

        if (estado == 0) {
            return new ResponseEntity<>("Estudiante Creado Con Éxito!!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error Al Crear El Estudiante", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * Retorna una lista con todos los estudiantes registrados.
     *
     * @return lista de estudiantes y estado HTTP correspondiente
     */
    @GetMapping("/mostrarTodo")
    public ResponseEntity<List<EstudianteDTO>> mostrarTodo() {
        List<EstudianteDTO> estudiantes = estudianteServ.findAll();

        if (estudiantes.isEmpty()) {
            return new ResponseEntity<>(estudiantes, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(estudiantes, HttpStatus.ACCEPTED);
        }
    }

    /**
     * Elimina un estudiante por su identificador (documento).
     *
     * @param id identificador del estudiante a eliminar
     * @return mensaje de estado y código HTTP
     */
    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        int status = estudianteServ.deleteById(id);

        if (status == 0) {
            return new ResponseEntity<>("Estudiante Eliminado Con Éxito!", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Error Al Eliminar Estudiante!", HttpStatus.NOT_FOUND);
        }
    }
}
