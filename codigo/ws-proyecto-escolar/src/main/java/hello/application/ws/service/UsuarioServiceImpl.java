package hello.application.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.application.ws.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private List<Usuario> listUsuarios;
	boolean existe;
	private Integer idUsuario = 1;
	
	
	public UsuarioServiceImpl(){
		this.listUsuarios = new ArrayList<>();
		listUsuarios.add(new Usuario(1,"admin", "admin", "admin", "administrador"));
		listUsuarios.add(new Usuario(2,"eugenio12345", "1234", "1234", "usuario"));
	}
	@Override
	public void crearActualizarUsuario(Usuario usuario) {
		if(usuario.getIdUsuario() == null){
			usuario.setIdUsuario(idUsuario++);
			usuario.setRol("usuario");
			listUsuarios.add(usuario);
		}
		
		this.listUsuarios.parallelStream().filter(s->s.getIdUsuario().equals(usuario)).map(s->{
			s.setIdUsuario(usuario.getIdUsuario());
			s.setConfirmPassword(usuario.getConfirmPassword());
			s.setContrasena(usuario.getContrasena());
			s.setNombreUsuario(usuario.getNombreUsuario());
			s.setRol(usuario.getRol());
			return s;
		});
		
	}

	@Override
	public boolean validarUsuario(Usuario user) {
		
		this.listUsuarios.stream().forEach(s->{
			if(user.getContrasena().equals(s.getContrasena())&&user.getNombreUsuario().equals(s.getNombreUsuario())){
			   existe = true;	
			}
		});
		return existe;
	}
	@Override
	public List<Usuario> cargarUsuarios() {
		return this.listUsuarios;
	}
	
	@Override
	public void eliminarUsuario(Integer id) {
		this.listUsuarios.removeIf(s->s.getIdUsuario().equals(id));
	}
	
	
	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = new Usuario ();
		this.listUsuarios.parallelStream().filter(s->s.getIdUsuario().equals(usuario)).map(s->{
			usuario.setIdUsuario(s.getIdUsuario());
			usuario.setConfirmPassword(s.getConfirmPassword());
			usuario.setContrasena(s.getContrasena());
			usuario.setNombreUsuario(s.getNombreUsuario());
			usuario.setRol(s.getRol());
			return usuario;
		});
		return usuario;
	}

}
