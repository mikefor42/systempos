package syscom.dao;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import syscom.domain.Persona;

@Component
public class PersonasDAOImpl implements PersonasDAO {
	
	public List<Persona> obtenerClientes() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);
		persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);		
		persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);				
		return personas;
	}

	public void guardarCliente(Persona cliente) {
		// TODO Auto-generated method stub
		
	}

	public Persona obtenerCliente(String idCliente) {
		// TODO Auto-generated method stub
		Persona p = new Persona();
		p.setNombre("Mke");
		p.setApellido("Hdez");
		return p;
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
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);
		persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);		
		persona = new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		personas.add(persona);				
		return personas;
	}

	public void guardarPersonal(Persona personal) {
		// TODO Auto-generated method stub
		
	}

	public Object obtenerPersonal() {
		Persona p = new Persona();
		p.setNombre("Mke");
		p.setApellido("Hdez");
		return p;
	}

	public Object obtenerProveedores() {
		List<Persona> personas = new ArrayList<Persona>();
		Persona p = Mockito.mock(Persona.class);
		p.setNombre("uno m");
		personas.add(p);
		return personas;
	}

	public void guardarProveedor(Persona proveedor) {
		// TODO Auto-generated method stub
		
	}

	public Persona obtenerProveedor(String idproveedor) {
		Persona p = new Persona();
		p.setNombre("Mke");
		p.setApellido("Hdez");
		return p;
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

}
