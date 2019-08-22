package hello.application.ws.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.application.ws.dto.ProductoDto;
import hello.application.ws.formatter.ProductoFormatter;
import hello.application.ws.model.Producto;
import hello.application.ws.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository productoRepository;
	
	private ProductoFormatter productoFormatter;
	
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public ProductoServiceImpl(ProductoRepository productoRepository, ProductoFormatter productoFormatter, EntityManagerFactory entityManagerFactory){
		this.productoRepository = productoRepository;
		this.productoFormatter = productoFormatter;
		this.entityManagerFactory =  entityManagerFactory;
	}
	
	@Override
	public void deleteProduct(Integer id) {
		this.productoRepository.deleteById(id);
		System.out.println(entityManagerFactory.toString());
	}

	@Override
	public void saveOrUpdateProduct(Producto producto) {
		this.productoRepository.save(productoFormatter.modelToDto(producto));
		
	}

	@Override
	public List<Producto> getAll() {
		List<ProductoDto>listDto = (List<ProductoDto>) this.productoRepository.findAll();
		
		return this.productoFormatter.getListDto(listDto);
	}

	@Override
	public Producto getById(Integer id) {
		ProductoDto dto = this.productoRepository.findById(id).get();
		Producto producto = this.productoFormatter.dtoToModel(dto);
		return producto;
	}
}