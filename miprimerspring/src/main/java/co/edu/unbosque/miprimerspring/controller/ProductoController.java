package co.edu.unbosque.miprimerspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.dto.ProductoDTO;
import co.edu.unbosque.miprimerspring.service.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = { "*" })
//@Transactional
public class ProductoController {

	@Autowired
	private ProductoService productoServ;
	
	public ProductoController() {
		// TODO Auto-generated constructor stub
	}
	

	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String nombre, @RequestParam String marca,
			@RequestParam int costo, @RequestParam int cantidad) {

		ProductoDTO nuevoProducto = new ProductoDTO(nombre, marca, costo, cantidad);

		int estado = productoServ.create(nuevoProducto);
		if (estado == 0) {
			
			return new ResponseEntity<>("Producto Creado Con Exito!!", HttpStatus.CREATED);

		} else {
		
			return new ResponseEntity<>("Error Al Crear El Producto", HttpStatus.NOT_ACCEPTABLE);
		
		}
	}
	
	@GetMapping("/mostrarTodo")
	public ResponseEntity<List<ProductoDTO>> mostrarTodo(){
		List<ProductoDTO> producto = productoServ.findAll();
		if(producto.isEmpty()) {
			return new ResponseEntity<List<ProductoDTO>>(producto, HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<ProductoDTO>>(producto, HttpStatus.ACCEPTED);
		}
	}
	
}
