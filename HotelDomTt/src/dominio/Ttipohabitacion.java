package dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ttipohabitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ttipohabitacion.findAll", query="SELECT t FROM Ttipohabitacion t")
public class Ttipohabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idTHab;

	private String descripcion;

	//bi-directional many-to-one association to Thabitacion
	@OneToMany(mappedBy="ttipohabitacion", fetch=FetchType.EAGER)
	private List<Thabitacion> thabitacions;

	public Ttipohabitacion() {
	}

	public String getIdTHab() {
		return this.idTHab;
	}

	public void setIdTHab(String idTHab) {
		this.idTHab = idTHab;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Thabitacion> getThabitacions() {
		return this.thabitacions;
	}

	public void setThabitacions(List<Thabitacion> thabitacions) {
		this.thabitacions = thabitacions;
	}

	public Thabitacion addThabitacion(Thabitacion thabitacion) {
		getThabitacions().add(thabitacion);
		thabitacion.setTtipohabitacion(this);

		return thabitacion;
	}

	public Thabitacion removeThabitacion(Thabitacion thabitacion) {
		getThabitacions().remove(thabitacion);
		thabitacion.setTtipohabitacion(null);

		return thabitacion;
	}

}