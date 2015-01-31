package syscom.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permiso {
	long ID;
	long IDPersonal;
	String modulo;	
	List<PermisoDetalle> crud;
	
	public Permiso() {
		this.ID = (long)(Math.random() * 10000); 
		this.IDPersonal = (long)(Math.random() * 10000); 
		this.modulo = "MOdulo"+ID;
		this.crud = new ArrayList<PermisoDetalle>();
		this.crud.add(new PermisoDetalle());
		this.crud.add(new PermisoDetalle());
		this.crud.add(new PermisoDetalle());
		this.crud.add(new PermisoDetalle());
	}
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getIDPersonal() {
		return IDPersonal;
	}
	public void setIDPersonal(long iDPersonal) {
		IDPersonal = iDPersonal;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public List<PermisoDetalle> getCrud() {
		return crud;
	}

	public void setCrud(List<PermisoDetalle> crud) {
		this.crud = crud;
	}
}
