package co.edu.unbosque.miprimerspring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspring.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	List<Producto> findByNombre(String nombre);

	void deleteByNombre(String nombre);
	
	//Optional<Producto> findByNombreOp(String nombre);

}
