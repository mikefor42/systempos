package syscom.dao;

import syscom.domain.Documento;
import syscom.domain.Producto;

public interface OperacionesDAO {

	
	void guardarDocumento(Documento documento);

	Object obtenerProductos();

	void actualizarInventario(Producto p);
	
	
}
