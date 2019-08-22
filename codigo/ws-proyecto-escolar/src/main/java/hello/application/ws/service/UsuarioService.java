package hello.application.ws.service;

import java.util.List;

import hello.application.ws.model.Usuario;

public interface UsuarioService {
	
    List<Usuario>cargarUsuarios();
	void crearActualizarUsuario(Usuario usuario);
	boolean validarUsuario(Usuario usuario);
	void eliminarUsuario(Integer id);
	Usuario obtenerPorId(Integer id);
	Usuario obtenerPorNombreYPass(Usuario user);
}
