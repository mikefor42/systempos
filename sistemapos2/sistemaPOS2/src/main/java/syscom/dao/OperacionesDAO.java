package syscom.dao;

import java.util.List;

import syscom.domain.Abono;
import syscom.domain.Cuenta;
import syscom.domain.DetalleDoc;
import syscom.domain.Documento;
import syscom.domain.Producto;

public interface OperacionesDAO {

	
	void guardarDocumento(Documento documento, List<DetalleDoc> detalleList);

	List<Producto> obtenerProductos();

	void actualizarInventario(Producto p);

	void abonarCuentaxCobrar(Abono abono);

	List<Cuenta> obtenerCuentasxPagar();

	void abonarCuentaxPagar(Abono abono);

	List<Cuenta> obtenerCuentasxCobrar();

	String obtenerNumeroDocumento();

	List<Documento> obtenerDocumentos();
}
