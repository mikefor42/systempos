package com.syscom.webapp.domain;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

    private String descripcion;
    private Double precio;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
    
    

}
