package syscom.domain;

public class Permiso {
	long ID;
	long IDPersonal;
	String modulo;	
	boolean crear;
	boolean leer;
	boolean actualizar;
	boolean eliminar;
	
	public Permiso() {
		this.ID = (long)(Math.random() * 10000); 
		this.IDPersonal = (long)(Math.random() * 10000); 
		this.modulo = "MOdulo"+ID;
		this.actualizar = true;
		this.eliminar = true;
		this.crear = true;
		this.leer = true;
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

	public boolean isLeer() {
		return leer;
	}

	public void setLeer(boolean leer) {
		this.leer = leer;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public boolean isCrear() {
		return crear;
	}

	public void setCrear(boolean crear) {
		this.crear = crear;
	}

	public boolean isActualizar() {
		return actualizar;
	}

	public void setActualizar(boolean actualizar) {
		this.actualizar = actualizar;
	}

	@Override
	public String toString() {
		return "Permiso [ID=" + ID + ", IDPersonal=" + IDPersonal + ", modulo="
				+ modulo + ", crear=" + crear + ", leer=" + leer
				+ ", actualizar=" + actualizar + ", eliminar=" + eliminar + "]";
	}
	
	
}
