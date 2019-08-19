package hello.application.ws.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hello.application.ws.model.Producto;
import hello.storage.StorageException;
import hello.storage.StorageFileNotFoundException;

@Service
public class ProductoServiceImpl implements ProductoService {

	private List<Producto> listProducts = null;
	private Path rootLocation ;
	private Integer idProducto = 5;

	public static final String uplodadDirectory = System.getProperty("user.home") + "/uploads-images";

	public ProductoServiceImpl() {
		listProducts = new ArrayList<>();
		listProducts.add(new Producto(1, "9189189", "Mezcal de cafe", 150.1));
		listProducts.add(new Producto(2, "9189190", "Mezcal de Jamaica", 250.0));
		listProducts.add(new Producto(3, "9189191", "Mezcal de Coco", 250.0));
		listProducts.add(new Producto(4, "9189192", "Vino Blanco", 5000.1));
		listProducts.add(new Producto(5, "9189193", "Vino Rojo", 5000.1));
		this.rootLocation = Paths.get("upload-dir");
	}

	
	@Override
	public List<Producto> deleteProduct(Integer id) {
		System.out.println("EL ID ES:::: " + id);
		this.listProducts.removeIf(s -> s.getId().equals(id));
		return listProducts;
	}

	@Override
	public void saveOrUpdateProduct(Producto producto) {
		 String filename = StringUtils.cleanPath(producto.getImagen().getOriginalFilename());
	        try {
	            if (producto.getImagen().isEmpty()) {
	                throw new StorageException("Failed to store empty file " + filename);
	            }
	            if (filename.contains("..")) {
	                // This is a security check
	                throw new StorageException(
	                        "Cannot store file with relative path outside current directory "
	                                + filename);
	            }
	            try (InputStream inputStream = producto.getImagen().getInputStream()) {
	                Files.copy(inputStream, this.rootLocation.resolve(filename),
	                    StandardCopyOption.REPLACE_EXISTING);
	            }
	        }
	        catch (IOException e) {
	            throw new StorageException("Failed to store file " + filename, e);
	        }
        System.out.println("LA RUTA EN LA QUE SE CARGO FUE LA SIGUIENTE "+filename);
		/**
		 * Entra a este metodo cuando el producto se registra por primera vez
		 */
		if (producto.getId() == null) {
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

	 public Resource loadAsResource(String filename) {
	        try {
	            Path file = load(filename);
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            }
	            else {
	                throw new StorageFileNotFoundException(
	                        "Could not read file: " + filename);

	            }
	        }
	        catch (MalformedURLException e) {
	            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
	        }
	    }
	 
	 public Path load(String filename) {
	        return rootLocation.resolve(filename);
	    }
	 
}
