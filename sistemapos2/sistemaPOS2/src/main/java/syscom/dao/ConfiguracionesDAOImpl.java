package syscom.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import syscom.domain.Almacen;
import syscom.domain.Sucursal;

public class ConfiguracionesDAOImpl implements ConfiguracionesDAO {

	public List<Sucursal> obtenerSucursales() {
		Sucursal s = new Sucursal();
		List<Sucursal> l = new ArrayList<Sucursal>();
		l.add(s);
		s = new Sucursal();
		l.add(s);
		s = new Sucursal();
		l.add(s);
		s = new Sucursal();
		l.add(s);		
		return l;
	}

	public List<Almacen> obtenerAlmacenes() {
		List<Almacen> l = new ArrayList<Almacen>();
		Almacen a = new Almacen();
		l.add(a);
		a = new Almacen();
		l.add(a);
		a = new Almacen();
		l.add(a);
		a = new Almacen();
		l.add(a);	
		return l;
	}
}
