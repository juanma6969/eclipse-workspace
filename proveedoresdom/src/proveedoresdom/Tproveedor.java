package proveedoresdom;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tproveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Tproveedor.findAll", query="SELECT t FROM Tproveedor t")
public class Tproveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProveedor;

	private String contacto;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Tlinea
	@OneToMany(mappedBy="tproveedor")
	private List<Tlinea> tlineas;

	public Tproveedor() {
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Tlinea> getTlineas() {
		return this.tlineas;
	}

	public void setTlineas(List<Tlinea> tlineas) {
		this.tlineas = tlineas;
	}

	public Tlinea addTlinea(Tlinea tlinea) {
		getTlineas().add(tlinea);
		tlinea.setTproveedor(this);

		return tlinea;
	}

	public Tlinea removeTlinea(Tlinea tlinea) {
		getTlineas().remove(tlinea);
		tlinea.setTproveedor(null);

		return tlinea;
	}

}