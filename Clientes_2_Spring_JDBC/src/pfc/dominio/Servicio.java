package pfc.dominio;

import java.util.GregorianCalendar;

public class Servicio {
	//Debido a que una relacion 1:N debemos tener un objeto de la clase cliente  
private int idServicio;
private String descripcion;
private GregorianCalendar fecha;
private double importe;
private Cliente cliente;




public Servicio(){}
public Servicio( String descripcion, GregorianCalendar fecha,
		double importe, Cliente cliente) {
	
	this.descripcion = descripcion;
	this.fecha = fecha;
	this.importe = importe;
	this.cliente = cliente;
}

public int getIdServicio() {
	return idServicio;
}
public void setIdServicio(int idServicio) {
	this.idServicio = idServicio;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public GregorianCalendar getFecha() {
	return fecha;
}
public void setFecha(GregorianCalendar fecha) {
	this.fecha = fecha;
}
public double getImporte() {
	return importe;
}
public void setImporte(double importe) {
	this.importe = importe;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

@Override
public String toString() {
	return "Servicio [idServicio=" + idServicio + ", descripcion=" + descripcion + ", fecha=" + fecha.getTime() + ", importe="
			+ importe + ", cliente=" + cliente + "]";
}

}

