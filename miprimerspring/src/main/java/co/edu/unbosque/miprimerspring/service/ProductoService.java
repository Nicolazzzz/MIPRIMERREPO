package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.dto.ProductoDTO;
import co.edu.unbosque.miprimerspring.model.Estudiante;
import co.edu.unbosque.miprimerspring.model.Producto;
import co.edu.unbosque.miprimerspring.repository.ProductoRepository;

/**
 * Servicio para manejar la lógica de negocio relacionada con los productos.
 * 
 * <p>Esta clase gestiona las operaciones CRUD (Crear, Leer) sobre los productos a través de un repositorio.</p>
 * 
 * @author Nicolas Zambrano
 */
@Service
public class ProductoService {
    
    // Repositorio para acceder a los datos de los productos
    @Autowired
    private ProductoRepository productoRepo;

    // Mapeador para convertir entre objetos DTO y entidades
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Crea un nuevo producto en la base de datos.
     * 
     * @param data El DTO que contiene los datos del producto a crear.
     * @return 0 si la operación fue exitosa, 1 si ocurrió un error.
     */
    public int create(ProductoDTO data) {
        
        // Convierte el DTO a una entidad Producto
        Producto entity = modelMapper.map(data, Producto.class);
        try {
            // Guarda la entidad en el repositorio
            productoRepo.save(entity);
            return 0;  // Éxito
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el error
            return 1;  // Error
        }
    }

    /**
     * Obtiene todos los productos de la base de datos y los devuelve como una lista de DTOs.
     * 
     * @return Lista de productos en formato DTO.
     */
    public List<ProductoDTO> findAll() {
        // Obtiene la lista de productos como entidades
        ArrayList<Producto> entityList = (ArrayList<Producto>) productoRepo.findAll();
        ArrayList<ProductoDTO> dtoList = new ArrayList<>();
        
        // Convierte cada entidad a un DTO y agrega a la lista
        entityList.forEach((entity) -> {
            ProductoDTO dto = modelMapper.map(entity, ProductoDTO.class);
            dtoList.add(dto);
        });
        
        return dtoList;  // Devuelve la lista de DTOs
    }

    /**
     * Obtiene el repositorio de productos.
     * 
     * @return El repositorio de productos.
     */
    public ProductoRepository getProductoRepo() {
        return productoRepo;
    }

    /**
     * Establece el repositorio de productos.
     * 
     * @param productoRepo El repositorio de productos.
     */
    public void setProductoRepo(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    /**
     * Obtiene el modelo de mapeo de entidades a DTOs.
     * 
     * @return El modelo de mapeo.
     */
    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    /**
     * Establece el modelo de mapeo de entidades a DTOs.
     * 
     * @param modelMapper El modelo de mapeo.
     */
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
