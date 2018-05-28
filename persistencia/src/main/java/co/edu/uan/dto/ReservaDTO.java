package co.edu.uan.dto;

public class ReservaDTO {
	
	private Integer idAlojamiento;
	private Integer idUsuario;
	private String nombreCompleto;
	private String numeroIdentificacion;
	private String direccion;
	private String telefono;
	private String celular;
	private String numeroTarjeta;
	private String fechaExpiracion;
	private String nombreTarjeta;
	private String fechaInicial;
	private String fechaFinal;
	private Integer pago;
	
	public ReservaDTO(Integer idAlojamiento, Integer idUsuario, String nombreCompleto, String numeroIdentificacion,
			String direccion, String telefono, String celular, String numeroTarjeta, String fechaExpiracion,
			String nombreTarjeta, Integer pago, String fechaInicial, String fechaFinal) {
		this.idAlojamiento = idAlojamiento;
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.numeroIdentificacion = numeroIdentificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.nombreTarjeta = nombreTarjeta;
		this.pago = pago;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public ReservaDTO(String nombreCompleto, String fechaInicial, String fechaFinal, Integer pago) {
		this.nombreCompleto = nombreCompleto;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.pago = pago;
	}



	public Integer getIdAlojamiento() {
		return idAlojamiento;
	}

	public void setIdAlojamiento(Integer idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getNombreTarjeta() {
		return nombreTarjeta;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public Integer getPago() {
		return pago;
	}

	public void setPago(Integer pago) {
		this.pago = pago;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
				
}
