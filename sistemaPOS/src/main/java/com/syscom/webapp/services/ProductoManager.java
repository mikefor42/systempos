package com.syscom.webapp.services;

import java.util.List;

import com.syscom.webapp.domain.Producto;

public interface ProductoManager {
	public void increasePrice(int percentage);

	public List<Producto> getProductos();
}
