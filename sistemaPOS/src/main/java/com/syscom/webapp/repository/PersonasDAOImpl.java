package com.syscom.webapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.syscom.webapp.domain.Persona;

@Repository(value="personasDao")
public class PersonasDAOImpl implements PersonasDAO {

	private EntityManager em = null;
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	
	public List<Persona> obtenerPersonasList() {
		return em.createQuery("select p from Persona p").getResultList();	
	}

	@Override
	
	public void guardarPersona(Persona persona) {
		em.merge(persona);
		
	}

	@Override
	public void eliminarPersona(int id) {
		Persona persona = em.find(Persona.class, id);
		em.remove(persona);		
	}

	@Override
	public void actualizarPersona(Persona persona) {
		em.merge(persona);		
	}
}
