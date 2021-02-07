package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tpedidolineas database table.
 * 
 */
@Entity
@Table(name="tpedidolineas")
@NamedQuery(name="pedidolinea.findAll", query="SELECT p FROM pedidolinea p")
public class pedidolinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinea;

	private byte cantidad;

	//bi-directional many-to-one association to pedido
	@ManyToOne
	@JoinColumn(name="IdPedido")
	private pedido tpedido;

	//bi-directional many-to-one association to producto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private producto tproducto;

	public pedidolinea() {
	}

	public int getIdLinea() {
		return this.idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public byte getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(byte cantidad) {
		this.cantidad = cantidad;
	}

	public pedido getTpedido() {
		return this.tpedido;
	}

	public void setTpedido(pedido tpedido) {
		this.tpedido = tpedido;
	}

	public producto getTproducto() {
		return this.tproducto;
	}

	public void setTproducto(producto tproducto) {
		this.tproducto = tproducto;
	}

}