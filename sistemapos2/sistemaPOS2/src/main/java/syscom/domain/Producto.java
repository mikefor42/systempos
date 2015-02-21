package syscom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_Producto")
	long ID;
	String descripcion;
	double precioVenta;
	double precioCompra;
	String imagenProducto;
	long ID_Grupo;
	
	@Transient
	double cantidadExistencia;
	@Transient
	double cantidadMinima;
	
	
	long id_proveedor;
	@Transient
	long almacen;
	
	@Transient
	String comentario;
	
	@Transient
	List<Atributo> atributos;
	 
	public Producto() {
		this.ID = (long)(Math.random() * 10000);
		this.descripcion = this.ID+"descripcion";
		this.precioVenta =(long)(Math.random() * 10000);
		this.precioCompra = (long)(Math.random() * 10000);
		this.imagenProducto = "Una imagen";
		
		this.cantidadExistencia = (long)(Math.random() * 10000);
		this.cantidadMinima = 1;
		
		this.id_proveedor = 1;
		this.almacen = 1;
		
		this.ID = 0;
//		
//		atributos = new ArrayList<AtributoProducto>();
//		atributos.add(new AtributoProducto(1));
//		atributos.add(new AtributoProducto(2));
//		atributos.add(new AtributoProducto(3));
//		atributos.add(new AtributoProducto(4));
//		atributos.add(new AtributoProducto(5));
	}
	
	
	
	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
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
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public String getImagenProducto() {
		return imagenProducto;
	}
	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	public double getCantidadExistencia() {
		return cantidadExistencia;
	}
	public void setCantidadExistencia(double cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
	}
	public double getCantidadMinima() {
		return cantidadMinima;
	}
	public void setCantidadMinima(double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public long getAlmacen() {
		return almacen;
	}
	public void setAlmacen(long almacen) {
		this.almacen = almacen;
	}

	
	



	public long getId_proveedor() {
		return id_proveedor;
	}



	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}



	public long getID_Grupo() {
		return ID_Grupo;
	}



	public void setID_Grupo(long iD_Grupo) {
		ID_Grupo = iD_Grupo;
	}



	@Override
	public String toString() {
		return "Producto [ID=" + ID + ", descripcion=" + descripcion
				+ ", precioVenta=" + precioVenta + ", precioCompra="
				+ precioCompra + ", imagenProducto=" + imagenProducto
				+ ", cantidadExistencia=" + cantidadExistencia
				+ ", cantidadMinima=" + cantidadMinima + ", proveedor="
				+ id_proveedor + ", almacen=" + almacen + ", comentario="
				+ comentario + ", atributos=" + atributos + "]";
	}
	
	public boolean tieneAtributo(AtributoProducto a){
		for(Atributo atributo : this.atributos){
			if(atributo.getID() == a.getID()) return true;
		} 
		return false;
	}
	
	
}
