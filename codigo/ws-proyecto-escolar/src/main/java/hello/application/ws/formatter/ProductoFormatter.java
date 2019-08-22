package hello.application.ws.formatter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hello.application.ws.dto.ProductoDto;
import hello.application.ws.model.Producto;

@Component
public class ProductoFormatter {

	private Producto producto;
	
	public ProductoDto modelToDto(Producto producto){
		ProductoDto dto = new ProductoDto();
		dto.setCodigo(producto.getCodigo());
		dto.setNombre(producto.getNombre());
		dto.setId(producto.getId());
		dto.setPrecio(producto.getPrecio());
		dto.setRutaImagen(producto.getRutaImagen());
		return dto;
	}
	
	public Producto dtoToModel(ProductoDto dto){
		Producto model  = new Producto();
		model.setId(dto.getId());
		model.setCodigo(dto.getCodigo());
		model.setNombre(dto.getNombre());
		model.setPrecio(dto.getPrecio());
		model.setRutaImagen(dto.getRutaImagen());
		return model;
	}
	
	public List<Producto>getListDto (List<ProductoDto>dtos){
		
		List<Producto>listProductos = new ArrayList<>();
		dtos.stream().forEach(s->{
			producto= new Producto();
			producto.setCodigo(s.getCodigo());
			producto.setId(s.getId());
			producto.setNombre(s.getNombre());
			producto.setPrecio(s.getPrecio());
			producto.setRutaImagen(s.getRutaImagen());
			listProductos.add(producto);
		});
		return listProductos;
	}
	
}
