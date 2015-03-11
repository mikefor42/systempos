package syscom.domain;

import java.io.Serializable;
import java.util.List;

public class Configuracion implements Serializable {
	
	String descripcion;
	
	long IDPermiso;
	long IDPersonal;
	List modulos;
	int crud;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getIDPermiso() {
		return IDPermiso;
	}
	public void setIDPermiso(long iDPermiso) {
		IDPermiso = iDPermiso;
	}
	public long getIDPersonal() {
		return IDPersonal;
	}
	public void setIDPersonal(long iDPersonal) {
		IDPersonal = iDPersonal;
	}
	public List getModulos() {
		return modulos;
	}
	public void setModulos(List modulos) {
		this.modulos = modulos;
	}
	public int getCrud() {
		return crud;
	}
	public void setCrud(int crud) {
		this.crud = crud;
	}	
}
