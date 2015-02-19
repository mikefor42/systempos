package syscom.domain;

import java.io.Serializable;

public class AtributoRow implements Serializable {
	long ID;
	String descripcion;
	String label;
	
	public AtributoRow(){
		this.ID = (long)(Math.random() * 10000);
		this.descripcion = "descripcion"+ID;
		this.label = "label"+ID;
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
