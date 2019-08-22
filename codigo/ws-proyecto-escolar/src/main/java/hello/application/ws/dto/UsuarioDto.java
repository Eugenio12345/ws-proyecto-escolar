package hello.application.ws.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Usuario")
@Entity
public class UsuarioDto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer idUsuario;
	private String nombreUsuario;
	private String contrasena;
	private String rol;
	
	
	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	

	public UsuarioDto(){
		
	}


	/**
	 * @param idUsuario
	 * @param nombreUsuario
	 * @param contrasena
	 * @param confirmPassword
	 * @param rol
	 */
	public UsuarioDto(Integer idUsuario, String nombreUsuario, String contrasena, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.rol = rol;
	}

}
