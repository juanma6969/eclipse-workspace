package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tlineafactura database table.
 * 
 */
@Entity
@NamedQuery(name="Tlineafactura.findAll", query="SELECT t FROM Tlineafactura t")
public class Tlineafactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TlineafacturaPK id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaFactura;

	private byte pagado;

	//bi-directional many-to-one association to Tfactura
	@ManyToOne
	@JoinColumn(name="IdFacturaF")
	private Tfactura tfactura;

	public Tlineafactura() {
	}

	public TlineafacturaPK getId() {
		return this.id;
	}

	public void setId(TlineafacturaPK id) {
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

	public Tfactura getTfactura() {
		return this.tfactura;
	}

	public void setTfactura(Tfactura tfactura) {
		this.tfactura = tfactura;
	}

}