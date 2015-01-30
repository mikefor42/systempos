package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import syscom.domain.Permiso;
import syscom.domain.Persona;

@Component
public class PersonasDAOImpl implements PersonasDAO {
	
	public List<Persona> obtenerClientes() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = new Persona();
		persona = new Persona();
		personas.add(persona);		
		persona = new Persona();
		personas.add(persona);				
		return personas;
	}

	public void guardarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		
	}

	public Persona obtenerCliente(String idCliente) {
		return new Persona();
	}

	public void editarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		
	}

	public void borrarCliente(String idCliente) {
		// TODO Auto-generated method stub
		
	}

	public void borrarPersonal(String idpersonal) {
		// TODO Auto-generated method stub
		
	}

	public void editarPersonal(Persona personal) {
		// TODO Auto-generated method stub
		
	}

	public List<Persona> obtenerPersonalList() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = new Persona();
		personas.add(persona);
		persona = new Persona();
		personas.add(persona);		
		persona = new Persona();
		personas.add(persona);				
		return personas;
	}

	public void guardarPersonal(Persona personal) {
		// TODO Auto-generated method stub
		
	}

	public Object obtenerPersonal() {
		return new Persona();
	}

	public Object obtenerProveedores() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona p = new Persona();		
		personas.add(p);
		p = new Persona();		
		personas.add(p);
		p = new Persona();		
		personas.add(p);
		return personas;
	}

	public void guardarProveedor(Persona proveedor) {
		// TODO Auto-generated method stub		
	}

	public Persona obtenerProveedor(String idproveedor) {
		return new Persona();
	}

	public void editarProveedor(Persona proveedor) {
		// TODO Auto-generated method stub		
	}

	public void borrarProveedor(String idproveedor) {
		// TODO Auto-generated method stub		
	}

	public Persona obtenerPersonal(String idpersonal) {		
		return new Persona();
	}

	public List<Permiso> obtenerPermisosPersonal(long id) {
		List<Permiso> l = new ArrayList<Permiso>();
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		l.add(new Permiso());
		return l;
	}
}
