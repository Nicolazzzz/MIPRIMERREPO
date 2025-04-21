package co.edu.unbosque.miprimerspring.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.unbosque.miprimerspring.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspring.model.Estudiante;
import co.edu.unbosque.miprimerspring.repository.EstudianteRepository;

@Service
public class EstudianteService {// Crear funciones de servicio APIS

	@Autowired
	private EstudianteRepository estudianteRepo;
	@Autowired
	private ModelMapper modelMapper;

	public int create(EstudianteDTO data) {

		Estudiante entity = modelMapper.map(data, Estudiante.class);

		try {
			estudianteRepo.save(entity);
			return 0;
		} catch (Exception e) {// SQL exception
			return 1;
		}

	}

	public ArrayList<EstudianteDTO> findAll() { // todas las listas son iguales, cambian las ENTIDADES y los DTOS
		ArrayList<Estudiante> entityList = (ArrayList<Estudiante>) estudianteRepo.findAll();
		ArrayList<EstudianteDTO> dtoList = new ArrayList<>();

		entityList.forEach((entity) -> {
			EstudianteDTO dto = modelMapper.map(entity, EstudianteDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}

	public int deleteById(Integer id) {
		Optional<Estudiante> found = estudianteRepo.findById(id);

		if (found.isPresent()) {
			estudianteRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}

	}
	
	

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
