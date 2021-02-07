package dominio;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable  {
	
	private static final  long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	@Temporal(TemporalType.DATE)
	    private Date fecha;
	    private String nombre;
	    private String email;
	    private String telefono;
	    private String direccion;
	    private String archivo;
	    
	    /*
	   Variable de tipo Servidor que e ha solicituado en la petición de reserva.
	     */
	    @JoinColumn(name="idServidor", referencedColumnName = "idServidor")
		@ManyToOne
	    private Servidor servidor;
	    
	    @JoinColumn(name="idUsuario", referencedColumnName = "idUsuario")
		@ManyToOne
	    private Servidor usuario;
	    
	    

	    public Solicitud() {
	      
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public String getArchivo() {
	        return archivo;
	    }

	    public void setArchivo(String archivo) {
	        this.archivo = archivo;
	    }
	    

	    public Servidor getUsuario() {
			return usuario;
		}

		public void setUsuario(Servidor usuario) {
			this.usuario = usuario;
		}

		public Servidor getServidor() {
	        return servidor;
	    }

	    public void setServidor(Servidor srv) {
	        this.servidor = srv;
	    }

	    @Override
	    public String toString() {
	        return "Solicitud{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", archivo=" + archivo + ", servidor=" + servidor + '}';
	    }
	
}
