package syscom.dao;

import syscom.domain.Documento;

public interface OperacionesDAO {

	
	void guardarDocumento(Documento documento);

	Object obtenerProductos();
	
	
}
