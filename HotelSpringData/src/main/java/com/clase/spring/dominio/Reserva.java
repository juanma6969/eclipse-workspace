package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="treserva")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservaPK id;

	private int idReserva;
	
	private byte ck_In;

	private byte ck_Out;
	
	private byte cancelada;

	//bi-directional many-to-one association to Temporada
	@ManyToOne
	@JoinColumn(name="IdTemporada")
	private Temporada temporada;

	@ManyToOne
	@JoinColumn(name="IdTarifa")
	private Tarifa tarifa;
	

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Habitacion
	@ManyToOne
	@JoinColumn(name="IdHabitacion")
	private Habitacion habitacion;

	//bi-directional many-to-one association to Tarifa
	

	@OneToMany(mappedBy="reserva", fetch=FetchType.EAGER)
	private List<Consumicion> lconsumiciones;

	@OneToMany(mappedBy="reserva", fetch=FetchType.EAGER)
	private List<Factura> lfacturas;

	

	public Reserva() {
	}

	public Reserva(ReservaPK id,Date fechaD,Date fechaH, int idReserva, byte ck_In, byte ck_Out, byte cancelada, Temporada temporada,
			Tarifa tarifa, Cliente cliente, Habitacion habitacion) {
		super();
		this.id = new ReservaPK(fechaD,fechaH,cliente.getIdCliente(),habitacion.getIdHabitacion());
		this.idReserva = idReserva;
		this.ck_In = ck_In;
		this.ck_Out = ck_Out;
		this.cancelada = cancelada;
		this.temporada = temporada;
		this.tarifa = tarifa;
		this.cliente = cliente;
		this.habitacion = habitacion;
	}

	public ReservaPK getId() {
		return this.id;
	}

	public void setId(ReservaPK id) {
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

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getTcliente() {
		return this.cliente;
	}

	public void setTcliente(Cliente tcliente) {
		this.cliente = tcliente;
	}

	public Habitacion getThabitacion() {
		return this.habitacion;
	}

	public void setThabitacion(Habitacion thabitacion) {
		this.habitacion = thabitacion;
	}

	public Tarifa getTtarifa() {
		return this.tarifa;
	}

	public void setTtarifa(Tarifa ttarifa) {
		this.tarifa = ttarifa;
	}

	public Temporada getTtemporada() {
		return this.temporada;
	}

	public void setTtemporada(Temporada ttemporada) {
		this.temporada = ttemporada;
	}

	
	public List<Consumicion> getLconsumiciones() {
		return lconsumiciones;
	}

	public void setLconsumiciones(List<Consumicion> lconsumiciones) {
		this.lconsumiciones = lconsumiciones;
	}

	public List<Factura> getLfacturas() {
		return lfacturas;
	}

	public void setLfacturas(List<Factura> lfacturas) {
		this.lfacturas = lfacturas;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", idReserva=" + idReserva + ", ck_In=" + ck_In + ", ck_Out=" + ck_Out
				+ ", cancelada=" + cancelada + ", temporada=" + temporada + ", tarifa=" + tarifa + ", cliente="
				+ cliente + ", habitacion=" + habitacion + "]";
	}
	

}
