package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tpedidolineas database table.
 * 
 */
@Entity
@Table(name="tpedidolineas")
@NamedQuery(name="PedidoLinea.findAll", query="SELECT p FROM PedidoLinea p")
public class PedidoLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinea;

	private byte cantidad;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="IdPedido")
	private Pedido tpedido;

	//bi-directional many-to-one association to producto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto tproducto;

	public PedidoLinea() {
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

	public Pedido getTpedido() {
		return this.tpedido;
	}

	public void setTpedido(Pedido tpedido) {
		this.tpedido = tpedido;
	}

	public Producto getTproducto() {
		return this.tproducto;
	}

	public void setTproducto(Producto tproducto) {
		this.tproducto = tproducto;
	}

}