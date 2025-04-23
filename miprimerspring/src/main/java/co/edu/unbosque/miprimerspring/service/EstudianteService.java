package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.model.Estudiante;
import co.edu.unbosque.miprimerspring.repository.EstudianteRepository;

/**
 * Servicio para la entidad Estudiante.
 * 
 * <p>Este servicio proporciona las operaciones de negocio para trabajar con la entidad {@link Estudiante}. 
 * Las operaciones incluyen la creación, obtención, eliminación de estudiantes y mapeo entre las entidades y sus DTOs.</p>
 * 
 * @author Nicolas Zambrano
 */
@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepo;  // Repositorio para la entidad Estudiante
    
    @Autowired
    private ModelMapper modelMapper;  // Herramienta para mapear entidades a DTOs

    /**
     * Crea un nuevo estudiante en la base de datos.
     * 
     * @param data El DTO del estudiante a crear.
     * @return Código de estado, 0 si la creación fue exitosa, 1 si ocurrió un error.
     */
    public int create(EstudianteDTO data) {
        Estudiante entity = modelMapper.map(data, Estudiante.class);  // Mapea el DTO a la entidad Estudiante

        try {
            estudianteRepo.save(entity);  // Guarda la entidad en la base de datos
            return 0;
        } catch (Exception e) {
            return 1;  // Error al guardar
        }
    }

    /**
     * Obtiene todos los estudiantes de la base de datos.
     * 
     * @return Una lista de DTOs de estudiantes.
     */
    public List<EstudianteDTO> findAll() {
        ArrayList<Estudiante> entityList = (ArrayList<Estudiante>) estudianteRepo.findAll();  // Obtiene todos los estudiantes
        ArrayList<EstudianteDTO> dtoList = new ArrayList<>();

        // Mapea cada entidad Estudiante a su DTO correspondiente
        entityList.forEach((entity) -> {
            EstudianteDTO dto = modelMapper.map(entity, EstudianteDTO.class);
            dtoList.add(dto);
        });

        return dtoList;
    }

    /**
     * Elimina un estudiante por su ID.
     * 
     * @param id El ID del estudiante a eliminar.
     * @return Código de estado, 0 si la eliminación fue exitosa, 1 si no se encontró el estudiante.
     */
    public int deleteById(Integer id) {
        Optional<Estudiante> found = estudianteRepo.findById(id);  // Busca el estudiante por ID

        if (found.isPresent()) {
            estudianteRepo.delete(found.get());  // Elimina el estudiante encontrado
            return 0;
        } else {
            return 1;  // Estudiante no encontrado
        }
    }

    // Métodos getter y setter para los campos de la clase

    public EstudianteRepository getEstudianteRepo() {
        return estudianteRepo;
    }

    public void setEstudianteRepo(EstudianteRepository estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
