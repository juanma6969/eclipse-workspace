package dominio;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;


public class Compra implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	//Atributos
	private int  idLinea;
	private int cantidad;
	private Calendar fecha;
	private double precio;
	private Producto producto;
	private Proveedor proveedor;
	//Constructor 
	public Compra() {}
	public Compra(int pCantidad,Calendar pFecha,double pPrecio,Producto pProducto,Proveedor pProveedor) {
		this.cantidad=pCantidad;
		this.fecha=pFecha;
		this.precio=pPrecio;
		this.producto=pProducto;
		this.proveedor=pProveedor;
	}
	//Getters and Setters
	public int getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	//Hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLinea;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (idLinea != other.idLinea)
			return false;
		return true;
	}
	//toString
	@Override
	public String toString() {
		return "LineaCompra [getIdLinea()=" + getIdLinea() + ", getCantidad()=" + getCantidad() + ", getFecha()="
				+ DateFormat.getDateInstance().format(this.getFecha().getTime())+ ", getPrecio()=" + getPrecio() + ", getProducto()=" + getProducto() + ", getProveedor()="
				+ getProveedor() + "]";
	}
	
	
	
	

}
