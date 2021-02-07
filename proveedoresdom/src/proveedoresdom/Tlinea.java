
package proveedoresdom;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the tlinea database table.
 * 
 *//*
@Entity
@NamedQuery(name="Tlinea.findAll", query="SELECT t FROM Tlinea t")
public class Tlinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinea;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double precio;

	//bi-directional many-to-one association to Tproducto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Tproducto tproducto;

	//bi-directional many-to-one association to Tproveedor
	@ManyToOne
	@JoinColumn(name="IdProveedor")
	private Tproveedor tproveedor;

	public Tlinea() {
	}

	public int getIdLinea() {
		return this.idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Tproducto getTproducto() {
		return this.tproducto;
	}

	public void setTproducto(Tproducto tproducto) {
		this.tproducto = tproducto;
	}

	public Tproveedor getTproveedor() {
		return this.tproveedor;
	}

	public void setTproveedor(Tproveedor tproveedor) {
		this.tproveedor = tproveedor;
	}
	}
	*/

