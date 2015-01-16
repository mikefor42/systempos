package com.syscom.webapp.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.syscom.webapp.domain.Producto;

public class SimpleProductoManagerTest {

	private SimpleProductoManager productoManager;
	private List<Producto> productos;
	private static int PRODUCT_COUNT = 2;
	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);
	
	private static int POSITIVE_PRICE_INCREASE = 10; 

	@Before
	public void setUp() {
		productoManager = new SimpleProductoManager();
		productos = new ArrayList<Producto>();
        
        // stub up a list of products
        Producto producto = new Producto();
        producto.setDescripcion("Chair");
        producto.setPrecio(CHAIR_PRICE);
        productos.add(producto);
        
        producto = new Producto();
        producto.setDescripcion("Table");
        producto.setPrecio(TABLE_PRICE);
        productos.add(producto);
        
        productoManager.setProductos(productos);
	}

	@Test
	public void testGetProductsWithNoProducts() {
		productoManager = new SimpleProductoManager();
		assertNull(productoManager.getProductos());
	}
	
	public void testGetProducts(){
        List<Producto> products = productoManager.getProductos();
        assertNotNull(products);        
        assertEquals(PRODUCT_COUNT, productoManager.getProductos().size());
    
        Producto product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescripcion());
        assertEquals(CHAIR_PRICE, product.getPrecio());
        
        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescripcion());
        assertEquals(TABLE_PRICE, product.getPrecio()); 
	}
	
	@Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productoManager = new SimpleProductoManager();
            productoManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productoManager = new SimpleProductoManager();
            productoManager.setProductos(new ArrayList<Producto>());
            productoManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Products list is empty.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
        productoManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Producto> products = productoManager.getProductos();      
        Producto product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrecio(), 0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getPrecio(), 0);       
    }

}
