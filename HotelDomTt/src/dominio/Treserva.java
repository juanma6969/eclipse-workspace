package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the treserva database table.
 * 
 */
@Entity
@NamedQuery(name="Treserva.findAll", query="SELECT t FROM Treserva t")
public class Treserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TreservaPK id;

	private byte cancelada;

	private byte ck_In;

	private byte ck_Out;

	//bi-directional many-to-one association to Tconsumicion
	@OneToMany(mappedBy="treserva", fetch=FetchType.EAGER)
	private List<Tconsumicion> tconsumicions;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente tcliente;

	//bi-directional many-to-one association to Thabitacion
	@ManyToOne
	@JoinColumn(name="IdHabitacion")
	private Thabitacion thabitacion;

	//bi-directional many-to-one association to Ttarifa
	@ManyToOne
	@JoinColumn(name="IdTarifa")
	private Ttarifa ttarifa;

	//bi-directional many-to-one association to Ttemporada
	@ManyToOne
	@JoinColumn(name="IdTemporada")
	private Ttemporada ttemporada;

	public Treserva() {
	}

	public TreservaPK getId() {
		return this.id;
	}

	public void setId(TreservaPK id) {
		this.id = id;
	}

	public byte getCancelada() {
		return this.cancelada;
	}

	public void setCancelada(byte cancelada) {
		this.cancelada = cancelada;
	}

	public byte getCk_In() {
		return this.ck_In;
	}

	public void setCk_In(byte ck_In) {
		this.ck_In = ck_In;
	}

	public byte getCk_Out() {
		return this.ck_Out;
	}

	public void setCk_Out(byte ck_Out) {
		this.ck_Out = ck_Out;
	}

	public List<Tconsumicion> getTconsumicions() {
		return this.tconsumicions;
	}

	public void setTconsumicions(List<Tconsumicion> tconsumicions) {
		this.tconsumicions = tconsumicions;
	}

	public Tconsumicion addTconsumicion(Tconsumicion tconsumicion) {
		getTconsumicions().add(tconsumicion);
		tconsumicion.setTreserva(this);

		return tconsumicion;
	}

	public Tconsumicion removeTconsumicion(Tconsumicion tconsumicion) {
		getTconsumicions().remove(tconsumicion);
		tconsumicion.setTreserva(null);

		return tconsumicion;
	}

	public Cliente getTcliente() {
		return this.tcliente;
	}

	public void setTcliente(Cliente tcliente) {
		this.tcliente = tcliente;
	}

	public Thabitacion getThabitacion() {
		return this.thabitacion;
	}

	public void setThabitacion(Thabitacion thabitacion) {
		this.thabitacion = thabitacion;
	}

	public Ttarifa getTtarifa() {
		return this.ttarifa;
	}

	public void setTtarifa(Ttarifa ttarifa) {
		this.ttarifa = ttarifa;
	}

	public Ttemporada getTtemporada() {
		return this.ttemporada;
	}

	public void setTtemporada(Ttemporada ttemporada) {
		this.ttemporada = ttemporada;
	}

}