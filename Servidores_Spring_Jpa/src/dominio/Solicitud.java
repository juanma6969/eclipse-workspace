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
@Table(name="tsolicitud")
public class Solicitud implements Serializable  {
	
	private static final  long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int IdSolicitud;
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
		    @JoinColumn(name="IdServidorC", referencedColumnName = "IdServidor")
			@ManyToOne
		    private Servidor servidor;
		    
		    @JoinColumn(name="IdUsuarioC", referencedColumnName = "IdUsuario")
			@ManyToOne
		    private Usuario usuario;
	    
	    public Solicitud(Date fecha, String nombre, String email, String telefono, String direccion, String archivo,
				Servidor servidor, Usuario usuario) {
			super();
			this.fecha = fecha;
			this.nombre = nombre;
			this.email = email;
			this.telefono = telefono;
			this.direccion = direccion;
			this.archivo = archivo;
			this.servidor = servidor;
			this.usuario = usuario;
		}

		
	    
	    

	    public Solicitud() {
	      
	    }

	    public int getId() {
	        return IdSolicitud;
	    }

	    public void setId(int id) {
	        this.IdSolicitud = id;
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
	    

	    public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
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
	        return "Solicitud{" + "id=" + IdSolicitud + ", fecha=" + fecha + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", archivo=" + archivo + ", servidor=" + servidor + '}';
	    }
	
}

