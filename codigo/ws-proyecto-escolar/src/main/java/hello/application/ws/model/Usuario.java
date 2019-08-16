package hello.application.ws.model;

public class Usuario {

	
	private String nombreUsuario;
	private String contrasena;
	private String confirmPassword;
	private String rol;
	
	
	
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

	

	public Usuario(){
		
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @param nombreUsuario
	 * @param contrasena
	 * @param confirmPassword
	 * @param rol
	 */
	public Usuario(String nombreUsuario, String contrasena, String confirmPassword, String rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.confirmPassword = confirmPassword;
		this.rol = rol;
	}
	
}
