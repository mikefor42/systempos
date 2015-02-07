package syscom.dao;

import java.util.List;
import java.util.Map;

import syscom.domain.Permiso;
import syscom.domain.Persona;


public interface PersonasDAO {
	public List<Persona> obtenerClientes(int opcion);
	public void guardarCliente(Persona cliente);
	public Persona obtenerCliente(String idCliente);
	public void editarCliente(Persona cliente);
	public void borrarCliente(String idCliente);

	public List<Persona> obtenerProveedores(int opcion);
	public void guardarProveedor(Persona proveedor);
	public Persona obtenerProveedor(String idproveedor);
	public void editarProveedor(Persona proveedor);
	public void borrarProveedor(String idproveedor);

	public List<Persona> obtenerPersonalList(int opcion);
	public void guardarPersonal(Persona personal);
	public Persona obtenerPersonal(String idpersonal);
	public void editarPersonal(Persona personal);
	public void borrarPersonal(String idpersonal);
	public List<Permiso> obtenerPermisosPersonal(long id);

	public void agregarModulo(long idPersona, long idModulo);
	public Map<Long, String> obtenerModulos();
}
