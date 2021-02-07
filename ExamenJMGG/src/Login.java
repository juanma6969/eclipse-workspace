import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuario")
@SessionScoped
public class Login {
	
	//Declaro las propiedades
	private String usuario;
	private String password;
	private String rol;
	private String texto;
	private Boolean compT=false;
	private String Act;
	
	public Login() {
	}
	//Realizo el Constructor 
	public Login(String usuario,String password, String rol,String act) {
		this.setUsuario(usuario);
		this.setPassword(password);
		this.setRol(rol);
	this.setAct(act);
		
	}
	
	
	//GetTEr&&SETTER de usuario
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
//Getter&&Setter de password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//Getter&&Setter de rol
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	//GeTTer && SeTTer de texto
	 
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String  bLogin() {
		String Result="";
		if (this.usuario.length()>0&&this.password.length()>0&&this.rol.length()>0){
			if(this.usuario.equalsIgnoreCase("juan")&&this.password.equalsIgnoreCase("juanito")&&this.rol.equalsIgnoreCase("user")){
				Result="user";
			}else {
				Result="error";
			}
			
			if (this.usuario.equalsIgnoreCase("pepe")&&this.password.equalsIgnoreCase("pepito")&&this.rol.equalsIgnoreCase("admin")){
				Result="admin";
				
			}
			
		}else {
			Result="error";	
		}
		return Result;
	}

	public String bSendText() {
		String textoDefault;
		
		
		
		if(this.compT==true&&this.texto.length()<=600) {
			return this.texto;
		}else {
		
			this.texto	=	textoDefault="Texto no visible"; 
return this.texto;
		}
		
	}
public void IsVisibleT() {
	if(this.Act.equalsIgnoreCase("Si")) {
		this.compT=true;
	
	}else {
		this.compT=false;
	}
	
}

public String getAct() {
	return Act;
}
public void setAct(String act) {
	Act = act;
}


	
	

}
