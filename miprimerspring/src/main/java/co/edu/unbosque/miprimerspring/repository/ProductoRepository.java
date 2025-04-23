package co.edu.unbosque.miprimerspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.model.Producto;

/**
 * Repositorio para la entidad Producto.
 * 
 * <p>Este repositorio extiende de {@link CrudRepository} y proporciona métodos para realizar operaciones CRUD en la base de datos para la entidad {@link Producto}.</p>
 * <p>Incluye métodos para buscar productos por nombre, eliminar productos por nombre, y otros métodos opcionales que podrían añadirse en el futuro.</p>
 * 
 * @author Nicolas Zambrano
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    /**
     * Busca una lista de productos por su nombre.
     * 
     * @param nombre El nombre del producto a buscar.
     * @return Una lista de productos cuyo nombre coincida con el proporcionado.
     */
    List<Producto> findByNombre(String nombre);

    /**
     * Elimina un producto por su nombre.
     * 
     * @param nombre El nombre del producto que se va a eliminar.
     */
    void deleteByNombre(String nombre);
    
    // Método opcional para buscar un producto por nombre de forma más detallada.
    // Optional<Producto> findByNombreOp(String nombre);

}
