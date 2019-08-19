package hello.application.ws.service;

import java.util.List;

import hello.application.ws.model.Producto;

public interface ProductoService {

	List<Producto> deleteProduct(Integer id);
	void saveOrUpdateProduct(Producto producto);
	List<Producto>getAll();
	Producto getById(Integer id);
}
