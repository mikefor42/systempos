package syscom.dao;

import java.util.List;

import syscom.domain.Documento;
import syscom.domain.Producto;

public interface OperacionesDAO {

	
	void guardarDocumento(Documento documento);

	List<Producto> obtenerProductos();

	void actualizarInventario(Producto p);
	
	
}
