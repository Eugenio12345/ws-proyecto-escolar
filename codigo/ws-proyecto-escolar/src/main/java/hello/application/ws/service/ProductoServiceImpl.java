package hello.application.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.application.ws.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	private List<Producto> listProducts = null;

	private Integer idProducto = 5;
	public ProductoServiceImpl() {
		listProducts = new ArrayList<>();
		listProducts.add(new Producto(1, "9189189", "Mezcal de cafe", 150.1));
		listProducts.add(new Producto(2, "9189190", "Mezcal de Jamaica", 250.0));
		listProducts.add(new Producto(3, "9189191", "Mezcal de Coco", 250.0));
		listProducts.add(new Producto(4, "9189192", "Vino Blanco", 5000.1));
		listProducts.add(new Producto(5, "9189193", "Vino Rojo", 5000.1));
	}

	@Override
	public List<Producto> deleteProduct(Integer id) {
		System.out.println("EL ID ES:::: "+id);
		this.listProducts.removeIf(s->s.getId().equals(id));
		return listProducts;
	}

	@Override
	public void saveOrUpdateProduct(Producto producto) {
		/**
		 * Entra a este metodo cuando el producto se registra por primera vez
		 */
		if(producto.getId()==null){
			producto.setId(idProducto++);
			this.listProducts.add(producto);
		}
		
		/**
		 * En caso contrario el producto solo actualiza sus propiedades
		 */
		this.listProducts.stream().filter(s -> s.getId().equals(producto.getId())).forEach(s -> {
            s.setCodigo(producto.getCodigo());
            s.setNombre(producto.getNombre());
            s.setPrecio(producto.getPrecio());
		});
	}

	@Override
	public List<Producto> getAll() {
		return this.listProducts;
	}

	@Override
	public Producto getById(Integer id) {
		Producto producto = new Producto();
		this.listProducts.stream().filter(s -> s.getId().equals(id)).forEach(s -> {
              producto.setCodigo(s.getCodigo());
              producto.setId(s.getId());
              producto.setNombre(s.getNombre());
              producto.setPrecio(s.getPrecio());
		});
		return producto;
	}



}
