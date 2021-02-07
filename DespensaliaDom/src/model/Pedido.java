package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tpedidos database table.
 * 
 */
@Entity
@Table(name="tpedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPedido;

	private Timestamp FHPedido;

	@Temporal(TemporalType.DATE)
	private Date FRecogida;

	private BigDecimal importe;

	private String observaciones;

	//bi-directional many-to-one association to PedidoLinea
	@OneToMany(mappedBy="tpedido", cascade={CascadeType.ALL})
	private List<PedidoLinea> tpedidolineas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente tcliente;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Timestamp getFHPedido() {
		return this.FHPedido;
	}

	public void setFHPedido(Timestamp FHPedido) {
		this.FHPedido = FHPedido;
	}

	public Date getFRecogida() {
		return this.FRecogida;
	}

	public void setFRecogida(Date FRecogida) {
		this.FRecogida = FRecogida;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<PedidoLinea> getTpedidolineas() {
		return this.tpedidolineas;
	}

	public void setTpedidolineas(List<PedidoLinea> tpedidolineas) {
		this.tpedidolineas = tpedidolineas;
	}

	public PedidoLinea addTpedidolinea(PedidoLinea tpedidolinea) {
		getTpedidolineas().add(tpedidolinea);
		tpedidolinea.setTpedido(this);

		return tpedidolinea;
	}

	public PedidoLinea removeTpedidolinea(PedidoLinea tpedidolinea) {
		getTpedidolineas().remove(tpedidolinea);
		tpedidolinea.setTpedido(null);

		return tpedidolinea;
	}

	public Cliente getTcliente() {
		return this.tcliente;
	}

	public void setTcliente(Cliente tcliente) {
		this.tcliente = tcliente;
	}

}