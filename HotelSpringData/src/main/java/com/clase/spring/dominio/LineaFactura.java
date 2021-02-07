package com.clase.spring.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tlineafactura")
public class LineaFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LineaFacturaPK id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaFactura;

	private byte pagado;

	//bi-directional many-to-one association to Tfactura
	@ManyToOne
	@JoinColumn(name="IdFacturaF")
	private Factura factura;

	public LineaFactura() {
	}

	public LineaFactura(LineaFacturaPK id, String descripcion, Date fechaFactura, byte pagado, Factura factura) {
		super();
		this.id = new LineaFacturaPK(factura.getIdFactura());
		this.descripcion = descripcion;
		this.fechaFactura = fechaFactura;
		this.pagado = pagado;
		this.factura = factura;
	}

	public LineaFacturaPK getId() {
		return this.id;
	}

	public void setId(LineaFacturaPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public byte getPagado() {
		return this.pagado;
	}

	public void setPagado(byte pagado) {
		this.pagado = pagado;
	}

	public Factura getTfactura() {
		return this.factura;
	}

	public void setTfactura(Factura tfactura) {
		this.factura = tfactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LineaFactura other = (LineaFactura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", descripcion=" + descripcion + ", fechaFactura=" + fechaFactura
				+ ", pagado=" + pagado + ", factura=" + factura + "]";
	}
	

}
