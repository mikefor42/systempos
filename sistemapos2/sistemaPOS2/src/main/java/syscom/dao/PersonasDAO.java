package syscom.dao;

import java.util.List;

import syscom.domain.Persona;


public interface PersonasDAO {

	public List<Persona> obtenerClientes();

	public void guardarCliente(Persona cliente);

	public Persona obtenerCliente(String idCliente);

	public void editarCliente(Persona cliente);

	public void borrarCliente(String idCliente);

	public Object obtenerProveedores();

	public void guardarProveedor(Persona proveedor);

	public Persona obtenerProveedor(String idproveedor);

	public void editarProveedor(Persona proveedor);

	public void borrarProveedor(String idproveedor);

	public List<Persona> obtenerPersonalList();

	public void guardarPersonal(Persona personal);

	public Persona obtenerPersonal(String idpersonal);

	public void editarPersonal(Persona personal);

	public void borrarPersonal(String idpersonal);



}
