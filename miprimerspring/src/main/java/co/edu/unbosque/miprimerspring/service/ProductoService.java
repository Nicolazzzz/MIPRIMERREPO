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

@Service 
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public int create(ProductoDTO data) {
		
		Producto entity = modelMapper.map(data, Producto.class);
		try {
			productoRepo.save(entity);
			return 0;
		} catch (Exception e) {//SQL exception
			return 1;
		}
		
		
	}
	
	public List<ProductoDTO> findAll() { //todas las listas son iguales, cambian las ENTIDADES y los DTOS
		ArrayList<Producto> entityList = (ArrayList<Producto>) productoRepo.findAll();
		ArrayList<ProductoDTO> dtoList = new ArrayList<>();
		
		entityList.forEach((entity) -> {
			ProductoDTO dto = modelMapper.map(entity, ProductoDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}

	public ProductoRepository getProductoRepo() {
		return productoRepo;
	}

	public void setProductoRepo(ProductoRepository productoRepo) {
		this.productoRepo = productoRepo;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	
	
}
