package co.edu.uan.dto;

public class Alojamiento {
	
	private Integer id;
	private String nombre;
	private String tipo;
	private Integer cantidadPersonas;
	private Integer cantidadHabitaciones;
	private Integer cantidadBanos;
	private String calefaccion;
	private String aireAcondicionado;
	private String mascotas;
	private String ciudad;
	private String direccion;
	private String barrio;
	private String descripcion;
	private Integer precio;
	
	public Alojamiento() {
		
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Integer getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public Integer getCantidadBanos() {
		return cantidadBanos;
	}

	public void setCantidadBanos(Integer cantidadBanos) {
		this.cantidadBanos = cantidadBanos;
	}

	public String getCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(String calefaccion) {
		this.calefaccion = calefaccion;
	}

	public String getAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(String aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public String getMascotas() {
		return mascotas;
	}

	public void setMascotas(String mascotas) {
		this.mascotas = mascotas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}	

}
