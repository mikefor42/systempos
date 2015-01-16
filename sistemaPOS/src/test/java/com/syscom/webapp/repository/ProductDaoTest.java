package com.syscom.webapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.syscom.webapp.domain.Persona;

public class ProductDaoTest {
	private ApplicationContext context;
	
	private PersonasDAO personasDao;
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		personasDao = (PersonasDAO) context.getBean("personasDao");
	}
	
	@Test
	public void testGetPersonasList(){
		List<Persona> personas = personasDao.obtenerPersonasList();
		assertEquals(personas.size(), 3, 0);
	}
	
	@Test
	public void testGuardarPersona(){
		List<Persona> personas = personasDao.obtenerPersonasList();
		
		Persona persona = personas.get(0);
		String nombre = persona.getNombre();
		persona.setNombre("Maria");
		personasDao.guardarPersona(persona);
		
		List<Persona> personas2 = personasDao.obtenerPersonasList();
		Persona persona2 = personas2.get(0);
		assertEquals(persona2.getNombre(), "Maria");
		
		persona2.setNombre("Miguel");
		personasDao.guardarPersona(persona2);
		
	}
	
}
	