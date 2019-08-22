package hello.application.ws.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.application.ws.dto.ProductoDto;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoDto, Integer> {

	@Query("SELECT u FROM ProductoDto u WHERE u.nombre = ?1")
	ProductoDto getByNombre(String nombre);
	
}
