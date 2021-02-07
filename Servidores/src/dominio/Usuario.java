package dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="usuario")
public class Usuario implements Serializable  {
	
	private static final  long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	    private String nombre;
	    private String email;
	    private String username;
	    private String password;
	    private String perfil;
	    private String estado = "activo";
	    ///////////////////////////////
	    @OneToMany(cascade=CascadeType.ALL,mappedBy = "usuario",fetch=FetchType.EAGER)
	    private List<Solicitud>solicitudes;

	    public Usuario() {
	     
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPerfil() {
	        return perfil;
	    }

	    public void setPerfil(String perfil) {
	        this.perfil = perfil;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    @Override
	    public String toString() {
	        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username + ", password=" + password + ", perfil=" + perfil + ", estado=" + estado + '}';
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (id != other.id)
				return false;
			return true;
		}


	    
}
