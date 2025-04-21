package co.edu.unbosque.miprimerspring.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.model.Estudiante;
import java.util.List;
import java.util.Optional;


public interface EstudianteRepository extends CrudRepository<Estudiante, Integer>{//T Type, ID ttipo de dato

	List<Estudiante> findByNombre(String nombre);
	
	void deleteByNombre(String nombre);
	
	Optional<Estudiante> findByDocumento(Integer documento);
}
