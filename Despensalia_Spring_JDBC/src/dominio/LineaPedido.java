package dominio;

import java.io.Serializable;

public class LineaPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idLinea;
	private Pedido pedido;
	private Producto producto;
	private int cantidad;
	
	public LineaPedido() {}
	public LineaPedido(int idLinea, Pedido pedido, Producto producto, int cantidad) {
		super();
		this.idLinea = idLinea;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdLinea() {
		return idLinea;
	}
	
	
	
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
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
		LineaPedido other = (LineaPedido) obj;
		if (idLinea != other.idLinea)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LineaPedido [getPedido()=" + getPedido() + ", getProducto()=" + getProducto() + ", getCantidad()="
				+ getCantidad() + ", getIdLinea()=" + getIdLinea() + "]";
	}
	
	
	

}
