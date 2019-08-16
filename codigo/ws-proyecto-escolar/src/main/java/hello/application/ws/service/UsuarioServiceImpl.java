package hello.application.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.application.ws.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private List<Usuario> listUsuarios;
	boolean existe;
	public UsuarioServiceImpl(){
		this.listUsuarios = new ArrayList<>();
		listUsuarios.add(new Usuario("admin", "admin", "admin", "administrador"));
	}
	@Override
	public void crearUsuario(Usuario user) {
		listUsuarios.add(user);
		
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

}
