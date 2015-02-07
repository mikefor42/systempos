package syscom.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import syscom.domain.Permiso;
import syscom.domain.Persona;

@Component
@Repository("personasDAO")
@Transactional
public class PersonasDAOImpl implements PersonasDAO {
	
	private static final String OBTENER_TODOS = "select p from Persona p";

	private EntityManager em;
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Persona> obtenerPersona(int opcion) {
		TypedQuery<Persona> query = em.createQuery(OBTENER_TODOS, Persona.class);
		return new ArrayList<Persona>();
	}

	public void guardarPersona(Persona persona) {
		em.persist(persona);	
	}

	public Persona obtenerPersona(String id) {
		return em.find(Persona.class, id);
	}

	public void editarPersona(Persona persona) {
		Persona c = em.find(Persona.class, persona.getID());
		em.setProperty("nombre", persona.getNombre());
		em.setProperty("apellido", persona.getApellido());
		em.setProperty("pais", persona.getPais());
		em.setProperty("estado", persona.getEstado());
		em.setProperty("municipio", persona.getMunicipio());
		em.setProperty("direccion", persona.getDireccion());
		em.setProperty("telefonoFijo", persona.getTelefonoFijo());
		em.setProperty("telefonoCelular", persona.getTelefonoCelular());
		em.setProperty("rfc", persona.getRfc());
		em.setProperty("email", persona.getEmail());
		em.setProperty("imagen", persona.getImagen());
		em.setProperty("usuario", persona.getUsuario());
	    em.setProperty("fecha_nac",persona.getFecha_nac());
	}

	public void borrarPersona(String id) {
		Persona c = em.find(Persona.class, id);	
		em.remove(c);
	}
	
	public void borrarPersonal(String idpersonal) {
		borrarPersona(idpersonal);
	}

	public void editarPersonal(Persona personal) {
		editarPersona(personal);		
	}

	public List<Persona> obtenerPersonalList(int opcion) {
		return obtenerPersona(opcion);
	}

	public void guardarPersonal(Persona personal) {
		guardarPersona(personal);
	}

	public List<Persona> obtenerProveedores(int opcion) {
		return obtenerPersona(opcion);	
	}

	public void guardarProveedor(Persona proveedor) {
		guardarPersona(proveedor);		
	}

	public Persona obtenerProveedor(String idproveedor) {
		return new Persona();
	}

	public void editarProveedor(Persona proveedor) {
		editarPersona(proveedor);
	}

	public void borrarProveedor(String idproveedor) {
		borrarPersona(idproveedor);
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

	public void agregarModulo(long idPersona, long idModulo) {
		// TODO Auto-generated method stub
		
	}

	public Map<Long, String> obtenerModulos() {
		Map map = new HashMap<Long, String>();
		map.put(1, "Modulo1");
		map.put(2, "Modulo2");
		map.put(3, "Modulo3");
		map.put(4, "Modulo4");
		map.put(5, "Modulo5");
		return map;
	}

	public List<Persona> obtenerClientes(int opcion) {
		return obtenerPersona(opcion);
	}

	public void guardarCliente(Persona cliente) {
		guardarPersona(cliente);		
	}

	public Persona obtenerCliente(String idCliente) {		
		return obtenerPersona(idCliente);
	}

	public void editarCliente(Persona cliente) {
		editarPersona(cliente);		
	}

	public void borrarCliente(String idCliente) {
		borrarPersona(idCliente);		
	}
}
