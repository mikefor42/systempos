package com.syscom.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.syscom.webapp.domain.Persona;
import com.syscom.webapp.repository.PersonasDAO;


@Component
public class PersonasManagerImpl implements PersonasManager {
	
	@Autowired
	private PersonasDAO personasDAO;

	@Override
	public List<Persona> obtenerPersonas() {
		return personasDAO.obtenerPersonasList();
	}

	@Override
	public void guardarPersona(Persona persona) {
		personasDAO.guardarPersona(persona);		
	}

	@Override
	public void actualizarPersona(Persona persona) {
		personasDAO.guardarPersona(persona);		
	}

	@Override
	public void eliminarPersona(int id) {
		personasDAO.eliminarPersona(id);
	}

	public void setPersonasDAO(PersonasDAO personasDAO) {
		this.personasDAO = personasDAO;
	}
}
