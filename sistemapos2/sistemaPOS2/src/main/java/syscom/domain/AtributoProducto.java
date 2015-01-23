package syscom.domain;

import java.io.Serializable;

public class AtributoProducto implements Serializable {
	long ID;
	long IDProducto;
	AtributoRow atributoRow;
	String valor; 
	
	public AtributoProducto() {
		this.ID = (long)(Math.random() * 10000);
		this.atributoRow = new AtributoRow();
		this.atributoRow.descripcion = "descripcion"+ID;
		this.valor = "valor"+ID;
		this.atributoRow.label = "label"+ID;
	}
	
	public AtributoProducto(long id) {
		this.ID = id;
		this.atributoRow = new AtributoRow();
		this.atributoRow.descripcion = "descripcion"+ID;
		this.valor = "valor"+ID;
		this.atributoRow.label = "label"+ID;
	}

	
	@Override
	public String toString() {
		return "Atributo [ID=" + ID + ", descripcion=" + atributoRow.descripcion
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		return this.ID == ((AtributoProducto) obj).getID();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) this.ID;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getIDProducto() {
		return IDProducto;
	}

	public void setIDProducto(long iDProducto) {
		IDProducto = iDProducto;
	}

	public AtributoRow getAtributoRow() {
		return atributoRow;
	}

	public void setAtributoRow(AtributoRow atributo) {
		this.atributoRow = atributo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}	
}
