package dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the thotel database table.
 * 
 */
@Entity
@NamedQuery(name="Thotel.findAll", query="SELECT t FROM Thotel t")
public class Thotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHotel;

	private String descripcion;

	private String email;

	private String gerente;

	private String nombre;

	private String provincia;

	private String telefono;

	public Thotel() {
	}

	public int getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGerente() {
		return this.gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}