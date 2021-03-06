package syscom.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="atributos")
public class Atributo implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_Atributos")
	long ID;
	String descripcion;
	String valor;
	

	

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
