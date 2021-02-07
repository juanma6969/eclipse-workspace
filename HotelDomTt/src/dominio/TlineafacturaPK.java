package dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tlineafactura database table.
 * 
 */
@Embeddable
public class TlineafacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idLineaFactura;

	@Column(insertable=false, updatable=false)
	private int idFacturaF;

	public TlineafacturaPK() {
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
		if (!(other instanceof TlineafacturaPK)) {
			return false;
		}
		TlineafacturaPK castOther = (TlineafacturaPK)other;
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