package co.edu.unbosque.miprimerspring.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.model.Estudiante;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Estudiante.
 * 
 * <p>Este repositorio extiende de {@link CrudRepository} y proporciona métodos para realizar operaciones CRUD en la base de datos para la entidad {@link Estudiante}.</p>
 * <p>Incluye métodos para buscar estudiantes por nombre, eliminar estudiantes por nombre y buscar un estudiante por documento.</p>
 * 
 * @author Nicolas Zambrano
 */
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> { // T es el tipo de la entidad, Integer es el tipo de la clave primaria

    /**
     * Busca una lista de estudiantes por su nombre.
     * 
     * @param nombre El nombre del estudiante a buscar.
     * @return Una lista de estudiantes cuyo nombre coincida con el proporcionado.
     */
    List<Estudiante> findByNombre(String nombre);

    /**
     * Elimina un estudiante por su nombre.
     * 
     * @param nombre El nombre del estudiante que se va a eliminar.
     */
    void deleteByNombre(String nombre);

    /**
     * Busca un estudiante por su número de documento.
     * 
     * @param documento El número de documento del estudiante a buscar.
     * @return Un {@link Optional} que contiene el estudiante si se encuentra, o un {@link Optional#empty()} si no se encuentra.
     */
    Optional<Estudiante> findByDocumento(Integer documento);
}
