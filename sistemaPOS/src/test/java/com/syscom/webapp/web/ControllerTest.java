package com.syscom.webapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.syscom.webapp.services.SimpleProductoManager;

public class ControllerTest {
	
	@Test
	public void testHandleRequestView() {
		PersonasController controlador = new PersonasController();
		ModelAndView modelAndView = controlador.handleRequest(null,null);
		controlador.setProductoManger(new SimpleProductoManager());
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}

}
