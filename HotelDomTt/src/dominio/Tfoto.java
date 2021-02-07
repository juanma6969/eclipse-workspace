package dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tfoto database table.
 * 
 */
@Entity
@NamedQuery(name="Tfoto.findAll", query="SELECT t FROM Tfoto t")
public class Tfoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFotos;

	private String descripcion;

	@Lob
	private byte[] imagen;

	//bi-directional many-to-one association to Thabitacion
	@ManyToOne
	@JoinColumn(name="IdHab")
	private Thabitacion thabitacion;

	public Tfoto() {
	}

	public int getIdFotos() {
		return this.idFotos;
	}

	public void setIdFotos(int idFotos) {
		this.idFotos = idFotos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Thabitacion getThabitacion() {
		return this.thabitacion;
	}

	public void setThabitacion(Thabitacion thabitacion) {
		this.thabitacion = thabitacion;
	}

}