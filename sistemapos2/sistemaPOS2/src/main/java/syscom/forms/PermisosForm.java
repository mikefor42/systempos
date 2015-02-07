package syscom.forms;

import java.util.List;
import java.util.Map;

import syscom.domain.Permiso;

public class PermisosForm {
	List<Permiso> permisosList;
	long IDPersona;
	long IDModulo;
	Map<Long, String> modulosmMap;

	public List<Permiso> getPermisosList() {
		return permisosList;
	}

	public void setPermisosList(List<Permiso> permisosList) {
		this.permisosList = permisosList;
	}

	public long getIDPersona() {
		return IDPersona;
	}

	public void setIDPersona(long iDPersona) {
		IDPersona = iDPersona;
	}

	public long getIDModulo() {
		return IDModulo;
	}

	public void setIDModulo(long iDModulo) {
		IDModulo = iDModulo;
	}

	public Map<Long, String> getModulosMap() {
		return modulosmMap;
	}

	public void setModulosMap(Map<Long, String> modulos) {
		this.modulosmMap = modulos;
	}
	
	
	
	
}
