package co.edu.unbosque.miprimerspring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.model.Estudiante;
import co.edu.unbosque.miprimerspring.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = { "*" })
//@Transactional
public class EstudianteController {

	// El controller llama al service, el service llama al repository
	@Autowired
	private EstudianteService estudianteServ;

	public EstudianteController() {
		super();
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String nombre, @RequestParam Integer documento,
			@RequestParam String programa, @RequestParam int semestre) {

		EstudianteDTO nuevoEstudiante = new EstudianteDTO(nombre, documento, programa, semestre);

		int estado = estudianteServ.create(nuevoEstudiante);
		if (estado == 0) {
			
			return new ResponseEntity<>("Estudiante Creado Con Exito!!", HttpStatus.CREATED);

		} else {
		
			return new ResponseEntity<>("Error Al Crear El Estudiante", HttpStatus.NOT_ACCEPTABLE);
		
		}
	}
	
	
	@GetMapping("/mostrarTodo")
	public ResponseEntity<ArrayList<EstudianteDTO>> mostrarTodo(){
		ArrayList<EstudianteDTO> estudiantes = estudianteServ.findAll();
		if(estudiantes.isEmpty()) {
			return new ResponseEntity<ArrayList<EstudianteDTO>>(estudiantes, HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<ArrayList<EstudianteDTO>>(estudiantes, HttpStatus.ACCEPTED);
		}
	}
	
	//si solo va a pedir un dato PathVariable
	
	@DeleteMapping("/eliminarPorId/{id}")//{id} parametro por id en el localhost
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		int status = estudianteServ.deleteById(id);
		if(status==0) {
			return new ResponseEntity<String>("Estudiante Eliminado Con Exito!", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Error Al Eliminar Estudiante!", HttpStatus.NOT_FOUND);
		}
		
	}
}
