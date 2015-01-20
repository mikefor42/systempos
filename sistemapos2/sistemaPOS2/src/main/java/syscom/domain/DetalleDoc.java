package syscom.domain;

import java.io.Serializable;

public class DetalleDoc implements Serializable {
	long ID;
	long IDProducto;
	double cantidad;
	double precio;
	double iva;
	double descuento;
	double subtotal;
	double total;
	Producto productoSeleccionado;
	
	public DetalleDoc(){
		 this.ID = (long)(Math.random() * 10000);		 
		 this.cantidad  = 3;
		 this.precio = 20;
		 this.iva =14;
		 this.descuento = 10;
		 this.subtotal = 200;
		 this.total = 300;
		
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
