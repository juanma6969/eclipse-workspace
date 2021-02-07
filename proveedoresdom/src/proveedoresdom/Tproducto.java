package proveedoresdom;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tproducto database table.
 * 
 * 
 */
/*
@Entity
@NamedQuery(name="Tproducto.findAll", query="SELECT t FROM Tproducto t")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Tlinea
	@OneToMany(mappedBy="tproducto")
	private List<Compra> tlineas;

	public Tproducto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tlinea> getTlineas() {
		return this.tlineas;
	}

	public void setTlineas(List<Compra> tlineas) {
		this.tlineas = tlineas;
	}

	public Tlinea addTlinea(Compra tlinea) {
		getTlineas().add(tlinea);
		tlinea.setTproducto(this);

		return tlinea;
	}

	public Tlinea removeTlinea(Compra tlinea) {
		getTlineas().remove(tlinea);
		tlinea.setTproducto(null);

		return tlinea;
	}
	

}*/