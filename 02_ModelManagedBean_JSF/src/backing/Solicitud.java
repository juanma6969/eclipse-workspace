package backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Usuario;

@ManagedBean
@RequestScoped
public class Solicitud {
    @ManagedProperty(value="#{usuario}")
	private Usuario usuario;
    
    public Solicitud() {}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    public String solicitar() {
    	if(this.usuario.getNombre().equals("Marina")) {
    		System.out.println("Correcto para usuario:" + this.usuario.getNombre());
    		return "correcto";
    	}else {
    		System.out.println("Incorrecto para usuario:  "  + this.usuario.getNombre());
    		return "incorrecto";
    	}
    }
	
}
