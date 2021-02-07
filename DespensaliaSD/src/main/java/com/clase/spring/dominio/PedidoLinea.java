package com.clase.spring.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tpedidolineas")
public class PedidoLinea implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinea;
	
	@ManyToOne
	@JoinColumn(name="IdPedido")
	private Pedido tpedido;
	
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto tproducto;
	private int cantidad;
	
	public PedidoLinea() {}
	public PedidoLinea(int idLinea, Pedido pedido, Producto producto, int cantidad) {
		super();
		this.idLinea = idLinea;
		this.tpedido = pedido;
		this.tproducto = producto;
		this.cantidad = cantidad;
	}
	public Pedido getPedido() {
		return tpedido;
	}
	public void setPedido(Pedido pedido) {
		this.tpedido = pedido;
	}
	public Producto getProducto() {
		return tproducto;
	}
	public void setProducto(Producto producto) {
		this.tproducto = producto;
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
		PedidoLinea other = (PedidoLinea) obj;
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
