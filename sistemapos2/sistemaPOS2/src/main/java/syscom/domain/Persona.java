package syscom.domain;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="personas")
public class Persona  implements Serializable {
	public static final int CLIENTE = 1;
	public static final int PROVEEDOR = 2;
	public static final int EMPLEADO = 3;
	
	@Id
	@Column(name="ID_Persona")	
	long ID;		
	@Size(min=1,max=250,message="Introduzca un nombre valido")
	String nombre;
	@Size(min=1,max=250,message="Introduzca un apellido valido")
	String apellido;
	String pais;
	String estado;
	String municipio;
	String direccion;
	String telefonoFijo;
	@Size(min=1,max=250,message="Introduzca un telefono valido")
	String telefonoCelular;
	String rfc;
	int activo;
	int tipo;
		
	String email;
	String imagen;
	String usuario;
	@Temporal(TemporalType.DATE)
	Date fecha_nac;
	
	public Persona () {
//		this.ID = (long)(Math.random() * 10000); 
//		this.nombre = "nombr"+this.ID;
//		this.apellido = "apellido"+this.ID;
//		this.pais = "pais"+this.ID;
//		this.estado = "estado"+this.ID;
//		this.municipio = "municipio"+this.ID;
//		this.direccion = "direccion"+this.ID;
//		this.telefonoFijo =	 "tFijo"+this.ID;
//		this.telefonoCelular = "tCel"+this.ID;
//		this.rfc = "rfc"+this.ID;
//		this.activo = 1;
//		this.tipo =	 0;
//		this.email = "email"+this.ID;
//		this.imagen = "imagen"+this.ID;	
//		this.fecha_nac = new Date();
//		this.usuario = "usuario"+ID;
//		this.ID = 0;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	
	
}
