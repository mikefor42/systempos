package web;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import syscom.web.HomeController;


public class HomeControllerTest {
	@Test
	public void debeMostrarLaPaginaPrincipal() {
		HomeController home = new HomeController();
		HashMap map = new HashMap();
	    String res = home.menuPrincipal(map);
		assertEquals("index",res);
	}	
}
