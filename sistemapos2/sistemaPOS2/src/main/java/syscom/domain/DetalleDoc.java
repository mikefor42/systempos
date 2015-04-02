package syscom.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="detalledocumentos")
public class DetalleDoc implements Serializable {
	@Id @Column(name="ID_Detalle_Factura")
	long ID;
	@Column(name="ID_Producto")
	long IDProducto;
	double cantidad;
	
	@Transient
	double precio;
	@Transient
	double iva;
	
	double descuento;
	
	@Transient
	double subtotal;

	double total;

	@Transient
	Producto productoSeleccionado;
	@Transient
	Documento documento;
	
	@Column(name="Factura_ID_Factura")
	String numDocumento;
	
	public DetalleDoc(){
//		 this.ID = (long)(Math.random() * 10000);
//		 this.IDProducto = 3;
//		 this.cantidad  = 3;
//		 this.precio = 20;
//		 this.iva =14;
//		 this.descuento = 10;
//		 this.subtotal = 200;
//		 this.total = 300;
//		 numDocumento = "1234";
		
	}
	
	
	


	public String getNumDocumento() {
		return numDocumento;
	}





	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}





	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}
	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
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
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
