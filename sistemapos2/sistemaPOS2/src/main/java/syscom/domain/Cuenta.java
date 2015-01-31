package syscom.domain;

import java.util.List;

public class Cuenta {
	long ID;
	long IDPersona;
	long IDDocumento;
	double Saldo;
	
	List<Abono> abonos;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getIDPersona() {
		return IDPersona;
	}

	public void setIDPersona(long iDPersona) {
		IDPersona = iDPersona;
	}

	public long getIDDocumento() {
		return IDDocumento;
	}

	public void setIDDocumento(long iDDocumento) {
		IDDocumento = iDDocumento;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(List<Abono> abonos) {
		this.abonos = abonos;
	}
}
