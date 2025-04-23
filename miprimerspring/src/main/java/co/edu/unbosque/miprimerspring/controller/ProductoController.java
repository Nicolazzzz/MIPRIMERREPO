package co.edu.unbosque.miprimerspring.controller;

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

import co.edu.unbosque.miprimerspring.dto.ProductoDTO;
import co.edu.unbosque.miprimerspring.service.ProductoService;

/**
 * Controlador para manejar operaciones relacionadas con los productos en la aplicación.
 * Permite crear nuevos productos y mostrar todos los productos almacenados.
 * 
 * @author Nicolas Zambrano
 */
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = { "*" })
public class ProductoController {

    @Autowired
    private ProductoService productoServ;

    /**
     * Constructor por defecto del controlador.
     */
    public ProductoController() {
        // Constructor vacío
    }

    /**
     * Ruta para crear un nuevo producto en el sistema.
     * 
     * @param nombre El nombre del producto.
     * @param marca La marca del producto.
     * @param costo El costo del producto.
     * @param cantidad La cantidad disponible del producto.
     * @return ResponseEntity con mensaje de éxito o error.
     */
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

    /**
     * Ruta para obtener todos los productos almacenados en el sistema.
     * 
     * @return ResponseEntity con lista de productos o mensaje de no contenido si no hay productos.
     */
    @GetMapping("/mostrarTodo")
    public ResponseEntity<List<ProductoDTO>> mostrarTodo(){
        List<ProductoDTO> producto = productoServ.findAll();
        if(producto.isEmpty()) {
            return new ResponseEntity<List<ProductoDTO>>(producto, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<ProductoDTO>>(producto, HttpStatus.ACCEPTED);
        }
    }
}
