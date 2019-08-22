package hello.application.ws.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import hello.application.ws.dto.UsuarioDto;

@Repository
@Component
public interface UsuarioRepository extends CrudRepository<UsuarioDto, Integer>{
	@Query("SELECT u FROM UsuarioDto u WHERE u.contrasena = ?1 and u.nombreUsuario = ?2")
	UsuarioDto getByUserPassword(String pass, String userName);
}
