package syscom.domain;

import java.util.Date;
import java.util.List;

public class Documento {
	long ID;
	long IDCliente;
	long IDPersonal;
	Date fecha;
	int status;
	double subtotal;
	double iva;
	double total;
	int numDocumento;
	int tipo;
	double descuento;
	List detalle;
	
	
	public List getDetalle() {
		return detalle;
	}
	public void setDetalle(List detalle) {
		this.detalle = detalle;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(long iDCliente) {
		IDCliente = iDCliente;
	}
	public long getIDPersonal() {
		return IDPersonal;
	}
	public void setIDPersonal(long iDPersonal) {
		IDPersonal = iDPersonal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(int numDocumento) {
		this.numDocumento = numDocumento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
