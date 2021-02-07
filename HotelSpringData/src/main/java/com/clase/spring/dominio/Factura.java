package com.clase.spring.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tfactura")
public class Factura {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFactura;

	@ManyToOne
	@JoinColumn(name="IdReservaR")
	private Reserva reserva;
	
	private byte cancelada;
	
	
	@OneToMany(mappedBy="factura", fetch=FetchType.EAGER)
	private List<LineaFactura> lFacturas;


	public Factura(Reserva reserva, byte cancelada) {
		super();
		this.reserva = reserva;
		this.cancelada = cancelada;
		
	}


	public int getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public byte getCancelada() {
		return cancelada;
	}


	public void setCancelada(byte cancelada) {
		this.cancelada = cancelada;
	}


	public List<LineaFactura> getlFacturas() {
		return lFacturas;
	}


	public void setlFacturas(List<LineaFactura> lFacturas) {
		this.lFacturas = lFacturas;
	}


	@Override
	public String toString() {
		final int maxLen = 10;
		return "Factura [idFactura=" + idFactura + ", reserva=" + reserva + ", cancelada=" + cancelada + ", lFacturas="
				+ (lFacturas != null ? lFacturas.subList(0, Math.min(lFacturas.size(), maxLen)) : null) + "]";
	}
	
	
}
