package syscom.domain;

import javax.persistence.Entity;

public class Par {
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
