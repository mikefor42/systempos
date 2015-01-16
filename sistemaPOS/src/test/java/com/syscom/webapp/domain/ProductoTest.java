package com.syscom.webapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	private Producto producto;
	
	
	@Before
	public void setUp() {
		producto = new Producto();
	}
	
	@Test
	public void testSetAndGetDescripcion() {
		String testDescripcion = "una descripcion";
		assertNull(producto.getDescripcion());
		producto.setDescripcion(testDescripcion);
		assertEquals(testDescripcion, producto.getDescripcion());
	}
	
	
	public void testSetAndGetPrecio(){
		double testPrecio = 100.00;
		assertEquals(0, 0, 0);
		producto.setPrecio(testPrecio);
		assertEquals(testPrecio, producto.getPrecio(), 0);
	}
	
	
	

}
