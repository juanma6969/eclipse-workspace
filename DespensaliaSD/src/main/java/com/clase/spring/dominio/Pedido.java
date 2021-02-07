package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tpedidos")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idPedido;
	

@Temporal(TemporalType.TIMESTAMP)
private Calendar fHPedido;

@Temporal(TemporalType.DATE)
private Calendar fHRecogida;
private double importe;
private String observaciones;

//Lista de lineas de pedido
@OneToMany(mappedBy="tpedido", fetch=FetchType.EAGER)
private List<PedidoLinea> Pedidolinea = new ArrayList<>();

@ManyToOne
@JoinColumn(name="IdCliente")
private Cliente tcliente;


public Pedido( Cliente cliente, Calendar fHPedido, Calendar fHRecogida, double importe,
		String observaciones) {
	super();
	this.tcliente = cliente;
	this.fHPedido = fHPedido;
	this.fHRecogida = fHRecogida;
	this.importe = importe;
	this.observaciones = observaciones;
}

public Pedido() {
	// TODO Auto-generated constructor stub
}

public Cliente getCliente() {
	return tcliente;
}

public void setCliente(Cliente cliente) {
	this.tcliente = cliente;
}

public Calendar getfHPedido() {
	return fHPedido;
}

public void setfHPedido(Calendar fHPedido) {
	this.fHPedido = fHPedido;
}

public Calendar getfHRecogida() {
	return fHRecogida;
}

public void setfHRecogida(Calendar fHRecogida) {
	this.fHRecogida = fHRecogida;
}

public double getImporte() {
	return importe;
}

public void setImporte(double importe) {
	this.importe = importe;
}

public String getObservaciones() {
	return observaciones;
}

public void setObservaciones(String observaciones) {
	this.observaciones = observaciones;
}

public List<PedidoLinea> getLineasPedido() {
	return Pedidolinea;
}

public void setLineasPedido(ArrayList<PedidoLinea> lineasPedido) {
	this.Pedidolinea = lineasPedido;
}

public int getIdPedido() {
	return idPedido;
}



public void setIdPedido(int idPedido) {
	this.idPedido = idPedido;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((fHPedido == null) ? 0 : fHPedido.hashCode());
	result = prime * result + ((fHRecogida == null) ? 0 : fHRecogida.hashCode());
	result = prime * result + idPedido;
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
	Pedido other = (Pedido) obj;
	if (fHPedido == null) {
		if (other.fHPedido != null)
			return false;
	} else if (!fHPedido.equals(other.fHPedido))
		return false;
	if (fHRecogida == null) {
		if (other.fHRecogida != null)
			return false;
	} else if (!fHRecogida.equals(other.fHRecogida))
		return false;
	if (idPedido != other.idPedido)
		return false;
	return true;
}

@Override
public String toString() {
	return "Pedido [getCliente()=" + getCliente() + ", getfHPedido()=" + getfHPedido() + ", getfHRecogida()="
			+ getfHRecogida() + ", getImporte()=" + getImporte() + ", getObservaciones()=" + getObservaciones()
			+ ", getLineasPedido()=" + getLineasPedido().size() + ", getIdPedido()=" + getIdPedido() + "]";
}
	






}
