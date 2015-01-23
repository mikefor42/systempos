package syscom.domain;

public class Atributo {
	long ID;
	String descripcion;
	String valor;
	String label;
	
	public Atributo() {
		this.ID = (long)(Math.random() * 10000);
		this.descripcion = "descripcion"+ID;
		this.valor = "valor"+ID;
		this.label = "label"+ID;
	}
	
	public Atributo(long id) {
		this.ID = id;
		this.descripcion = "descripcion"+ID;
		this.valor = "valor"+ID;
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
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "Atributo [ID=" + ID + ", descripcion=" + descripcion
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		return this.ID == ((Atributo) obj).getID();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) this.ID;
	}	
	
	
}
