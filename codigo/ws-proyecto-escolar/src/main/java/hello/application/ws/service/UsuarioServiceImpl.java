package hello.application.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.application.ws.dto.UsuarioDto;
import hello.application.ws.formatter.UsuarioFormatter;
import hello.application.ws.model.Usuario;
import hello.application.ws.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioFormatter usuarioFormatter;
	
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	public UsuarioServiceImpl (UsuarioFormatter usuarioFormatter, UsuarioRepository usuarioRepository){
		this.usuarioFormatter = usuarioFormatter;
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<Usuario> cargarUsuarios() {
		List<UsuarioDto>dtos = (List<UsuarioDto>) this.usuarioRepository.findAll();
		return this.usuarioFormatter.getList(dtos);
	}

	@Override
	public void crearActualizarUsuario(Usuario usuario) {
		this.usuarioRepository.save(this.usuarioFormatter.modelToDto(usuario));
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		return this.usuarioRepository.existsById(usuario.getIdUsuario());
	}

	@Override
	public void eliminarUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		UsuarioDto dto = this.usuarioRepository.findById(id).get();
		return this.usuarioFormatter.dtoToModel(dto);
	}

	@Override
	public Usuario obtenerPorNombreYPass(Usuario user) {
		UsuarioDto dto = this.usuarioRepository.getByUserPassword(user.getContrasena(), user.getNombreUsuario());
		return this.usuarioFormatter.dtoToModel(dto);
	}
}
