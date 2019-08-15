package hello.application.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hello.application.ws.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private List<Usuario> listUsuarios;
	public UsuarioServiceImpl(){
		this.listUsuarios = new ArrayList<>();
		listUsuarios.add(new Usuario("admin", "admin"));
	}
	@Override
	public void crearUsuario(Usuario user) {
		listUsuarios.add(user);
		
	}

	@Override
	public boolean validarUsuario(Usuario user) {
		return this.cargarUsuarios().contains(user);
	}

	@Override
	public List<Usuario> cargarUsuarios() {
		return this.listUsuarios;
	}

}
