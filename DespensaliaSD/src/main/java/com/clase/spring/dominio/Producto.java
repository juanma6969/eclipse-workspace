package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tproductos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String ENTRANTE = "ENTRANTE";
	public static final String PLATO    = "PLATO";
	public static final String POSTRE   = "POSTRE";
	public static final String VARIOS   = "VARIOS";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;
private String  nombre;
private String descripcion;
private double precio;
private String tipo;
private int disponible;


@OneToMany(mappedBy="tproducto", fetch=FetchType.EAGER)
private List<PedidoLinea> lineasPedido= new ArrayList<>();

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
public List<PedidoLinea> getLineasPedido() {
	return lineasPedido;
}
public void setLineasPedido(ArrayList<PedidoLinea> lineasPedido) {
	this.lineasPedido = lineasPedido;
}
public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
	result = prime * result + disponible;
	result = prime * result + idProducto;
	result = prime * result + ((lineasPedido == null) ? 0 : lineasPedido.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	long temp;
	temp = Double.doubleToLongBits(precio);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
	Producto other = (Producto) obj;
	if (descripcion == null) {
		if (other.descripcion != null)
			return false;
	} else if (!descripcion.equals(other.descripcion))
		return false;
	if (disponible != other.disponible)
		return false;
	if (idProducto != other.idProducto)
		return false;
	if (lineasPedido == null) {
		if (other.lineasPedido != null)
			return false;
	} else if (!lineasPedido.equals(other.lineasPedido))
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
		return false;
	if (tipo == null) {
		if (other.tipo != null)
			return false;
	} else if (!tipo.equals(other.tipo))
		return false;
	return true;
}
@Override
public String toString() {
	return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
			+ precio + ", tipo=" + tipo + ", disponible=" + disponible + ", lineasPedido=" + lineasPedido + "]";
}



}
