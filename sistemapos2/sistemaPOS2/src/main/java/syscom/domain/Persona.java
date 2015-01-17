package syscom.domain;

public class Persona {
	public static final int CLIENTE = 1;
	public static final int PROVEEDOR = 2;
	public static final int EMPLEADO = 3;
	
	long ID; 
	String nombre;
	String apellido;
	String pais;
	String estado;
	String municipio;
	String direccion;
	String telefonoFijo;
	String telefonoCelular;
	String rfc;
	int activo;
	int tipo;
	String email;
	String imagen;
	
	

	
	public Persona () {
		this.ID = (long) Math.random(); 
		this.nombre = "nombr"+this.ID;
		this.apellido = "apellido"+this.ID;
		this.pais = "pais"+this.ID;
		this.estado = "estado"+this.ID;
		this.municipio = "municipio"+this.ID;
		this.direccion = "direccion"+this.ID;
		this.telefonoFijo =	 "telefonoFijo"+this.ID;
		this.telefonoCelular = "telefonoCelular"+this.ID;
		this.rfc = "rfc"+this.ID;
		this.activo = 1;
		this.tipo =	 0;
		this.email = "email"+this.ID;
		this.imagen = "imagen"+this.ID;		
	}
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

	
	
}
