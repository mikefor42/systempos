package com.syscom.webapp.services;

import java.util.List;

import com.syscom.webapp.domain.Persona;

public interface PersonasManager{
	public List<Persona> obtenerPersonas();
	public void guardarPersona(Persona persona);
	public void actualizarPersona(Persona persona);
	public void eliminarPersona(int id);		
}
