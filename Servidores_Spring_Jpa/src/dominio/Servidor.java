package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tservidor")
public class Servidor implements Serializable {
	
	private static final  long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int IdServidor;
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}



	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	@Temporal(TemporalType.DATE)
	    private Date fechaPublicacion;
	    private String nombre;
	    private String descripcion;
	    private String detalle;
	    @OneToMany(cascade=CascadeType.ALL,mappedBy = "servidor",fetch=FetchType.EAGER)
	    private List<Solicitud>solicitudes;
	    
	    
	    
	    
	    
	    
	    public Servidor( String nombre, String descripcion, String detalle) {
			super();
			this.fechaPublicacion =new Date();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.detalle = detalle;
		}



		public Servidor() {
	        // La fecha de publicacion es la fecha del servidor
	        this.fechaPublicacion = new Date();
	    }
	    
	    

	    public int getId() {
	        return IdServidor;
	    }

	    public void setId(int id) {
	        this.IdServidor = id;
	    }

	    public Date getFechaPublicacion() {
	        return fechaPublicacion;
	    }

	    public void setFechaPublicacion(Date fechaPublicacion) {
	        this.fechaPublicacion = fechaPublicacion;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getDetalle() {
	        return detalle;
	    }

	    public void setDetalle(String detalle) {
	        this.detalle = detalle;
	    }

	    @Override
	    public String toString() {
	        return "Servidor{" + "id=" + IdServidor + ", fechaPublicacion=" + fechaPublicacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", detalle=" + detalle + '}';
	    }
}

