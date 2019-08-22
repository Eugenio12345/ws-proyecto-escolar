package hello.application.ws.formatter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hello.application.ws.dto.UsuarioDto;
import hello.application.ws.model.Usuario;

@Component
public class UsuarioFormatter {

	private Usuario model;
	
	public UsuarioDto modelToDto(Usuario usuario){
		UsuarioDto dto = new UsuarioDto();
		dto.setContrasena(usuario.getContrasena());
		dto.setIdUsuario(usuario.getIdUsuario());
		dto.setNombreUsuario(usuario.getNombreUsuario());
		dto.setRol(usuario.getRol());
		return dto;
	}
	
	public Usuario dtoToModel(UsuarioDto dto){
		Usuario model = new Usuario();
		model.setContrasena(dto.getContrasena());
		model.setIdUsuario(dto.getIdUsuario());
		model.setNombreUsuario(dto.getNombreUsuario());
		model.setRol(dto.getRol());
		return model;
	}
	
	public List<Usuario>getList(List<UsuarioDto>dtos){
       List<Usuario>listUsuarios= new ArrayList<>();	
       
       dtos.stream().forEach(dto->{
    	   model = new Usuario();
   		model.setContrasena(dto.getContrasena());
   		model.setIdUsuario(dto.getIdUsuario());
   		model.setNombreUsuario(dto.getNombreUsuario());
   		model.setRol(dto.getRol());
   		listUsuarios.add(model);
       });
       return listUsuarios;
	}
}
