package com.clase.spring.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class LineaFacturaPK implements Serializable{
	private static final long serialVersionUID = 1L;

	private int idLineaFactura;

	@Column(insertable=false, updatable=false)
	private int idFacturaF;

	public LineaFacturaPK() {
	}
	
	public LineaFacturaPK( int idFacturaF) {
		super();
		this.idFacturaF = idFacturaF;
	}

	public int getIdLineaFactura() {
		return this.idLineaFactura;
	}
	public void setIdLineaFactura(int idLineaFactura) {
		this.idLineaFactura = idLineaFactura;
	}
	public int getIdFacturaF() {
		return this.idFacturaF;
	}
	public void setIdFacturaF(int idFacturaF) {
		this.idFacturaF = idFacturaF;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LineaFacturaPK)) {
			return false;
		}
		LineaFacturaPK castOther = (LineaFacturaPK)other;
		return 
			(this.idLineaFactura == castOther.idLineaFactura)
			&& (this.idFacturaF == castOther.idFacturaF);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLineaFactura;
		hash = hash * prime + this.idFacturaF;
		
		return hash;
	}
}
