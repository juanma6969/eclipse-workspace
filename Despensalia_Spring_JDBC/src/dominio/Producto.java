package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String ENTRANTE = "ENTRANTE";
	public static final String PLATO    = "PLATO";
	public static final String POSTRE   = "POSTRE";
	public static final String VARIOS   = "VARIOS";
	
	private int idProducto;
private String  nombre;
private String descripcion;
private double precio;
private String tipo;
private int disponible;
private ArrayList<LineaPedido> lineasPedido= new ArrayList<>();

public Producto() {}
public Producto(int idProducto, String nombre, String descripcion, double precio, String tipo, int disponible) {
	super();
	this.idProducto = idProducto;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
	this.tipo = tipo;
	this.disponible = disponible;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public int getDisponible() {
	return disponible;
}
public void setDisponible(int disponible) {
	this.disponible = disponible;
}
public ArrayList<LineaPedido> getLineasPedido() {
	return lineasPedido;
}
public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
	this.lineasPedido = lineasPedido;
}
public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}



}
