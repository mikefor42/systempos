package com.syscom.webapp.services;

import java.util.List;

import com.syscom.webapp.domain.Producto;

public class SimpleProductoManager implements ProductoManager {

	 private static final long serialVersionUID = 1L;
	 private List<Producto> productos;
	
	@Override
	public void increasePrice(int percentage) {
		if(productos != null){
			for(Producto producto: productos){
				double nuevo = producto.getPrecio().doubleValue() * (100 + percentage)/100;
				producto.setPrecio(nuevo);
			}
		} else {
			System.out.println("No se encontraron productos");
		}		
	}

	@Override
	public List<Producto> getProductos() {
		return productos;
		
	}
	
	public void setProductos( List<Producto> productos){
		this.productos = productos;
	}

}
