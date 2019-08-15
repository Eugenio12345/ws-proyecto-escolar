package hello.application.ws.service;

import java.util.List;

import hello.application.ws.model.Usuario;

public interface UsuarioService {
    List<Usuario>cargarUsuarios();
	void crearUsuario(Usuario user);
	boolean validarUsuario(Usuario user);
	
}
