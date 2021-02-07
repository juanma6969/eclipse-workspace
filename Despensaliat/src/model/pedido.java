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
@NamedQuery(name="pedido.findAll", query="SELECT p FROM pedido p")
public class pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;

	private Timestamp FHPedido;

	@Temporal(TemporalType.DATE)
	private Date frecogida;

	private BigDecimal importe;

	private String observaciones;

	//bi-directional many-to-one association to pedidolinea
	@OneToMany(mappedBy="tpedido", fetch=FetchType.EAGER)
	private List<pedidolinea> tpedidolineas;

	//bi-directional many-to-one association to cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private cliente tcliente;

	public pedido() {
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

	public Date getFrecogida() {
		return this.frecogida;
	}

	public void setFrecogida(Date frecogida) {
		this.frecogida = frecogida;
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

	public List<pedidolinea> getTpedidolineas() {
		return this.tpedidolineas;
	}

	public void setTpedidolineas(List<pedidolinea> tpedidolineas) {
		this.tpedidolineas = tpedidolineas;
	}

	public pedidolinea addTpedidolinea(pedidolinea tpedidolinea) {
		getTpedidolineas().add(tpedidolinea);
		tpedidolinea.setTpedido(this);

		return tpedidolinea;
	}

	public pedidolinea removeTpedidolinea(pedidolinea tpedidolinea) {
		getTpedidolineas().remove(tpedidolinea);
		tpedidolinea.setTpedido(null);

		return tpedidolinea;
	}

	public cliente getTcliente() {
		return this.tcliente;
	}

	public void setTcliente(cliente tcliente) {
		this.tcliente = tcliente;
	}

}