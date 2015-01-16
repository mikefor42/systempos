package com.syscom.webapp.repository;

import java.util.List;

import com.syscom.webapp.domain.Persona;

public interface PersonasDAO {
	public List<Persona> obtenerPersonasList();
	public void guardarPersona(Persona persona);
	public void eliminarPersona(int id);
	public void actualizarPersona(Persona persona);
}
