package syscom.domain;

import java.io.Serializable;

import javax.persistence.Entity;

public class Par implements Serializable {
	int clave;
	String descripcion;
	
	public Par(int clave, String descripcion) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
