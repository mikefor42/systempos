package syscom.domain;

import java.io.Serializable;

public class Almacen implements Serializable {
	long ID;
	String descripcion;
	long IDSucursal;
	
	public Almacen() {
		this.ID =(long)(Math.random() * 10000);
		this.descripcion = "descripcion"+ID;
	}
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getIDSucursal() {
		return IDSucursal;
	}
	public void setIDSucursal(long iDSucursal) {
		IDSucursal = iDSucursal;
	}
	
	
}
