package syscom.domain;

public class Atributo {
	long ID;
	String descripcion;
	String valor;
	
	public Atributo() {
		this.ID = (long)(Math.random() * 10000);
		this.descripcion = "descripcion"+ID;
		this.valor = "valor"+ID;
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
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
