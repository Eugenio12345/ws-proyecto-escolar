package hello.application.ws.model;

public class Producto {

	
	private Integer id;
	
	private String codigo;

	private String nombre;
	
	private Double precio;

	
	public Producto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param precio
	 */
	public Producto(Integer id, String codigo, String nombre, Double precio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

}
