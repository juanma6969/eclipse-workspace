package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tproductos database table.
 * 
 */
@Entity
@Table(name="tproductos")
@NamedQuery(name="producto.findAll", query="SELECT p FROM producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;

	private String descripcion;

	private byte disponible;

	private String nombre;

	private BigDecimal precio;

	private String tipo;

	//bi-directional many-to-one association to PedidoLinea
	@OneToMany(mappedBy="tproducto")
	private List<PedidoLinea> tpedidolineas;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getDisponible() {
		return this.disponible;
	}

	public void setDisponible(byte disponible) {
		this.disponible = disponible;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<PedidoLinea> getTpedidolineas() {
		return this.tpedidolineas;
	}

	public void setTpedidolineas(List<PedidoLinea> tpedidolineas) {
		this.tpedidolineas = tpedidolineas;
	}

	public PedidoLinea addTpedidolinea(PedidoLinea tpedidolinea) {
		getTpedidolineas().add(tpedidolinea);
		tpedidolinea.setTproducto(this);

		return tpedidolinea;
	}

	public PedidoLinea removeTpedidolinea(PedidoLinea tpedidolinea) {
		getTpedidolineas().remove(tpedidolinea);
		tpedidolinea.setTproducto(null);

		return tpedidolinea;
	}

}