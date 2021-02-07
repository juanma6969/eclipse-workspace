package administrador;
public class Administrador {
	private String usuario;
	private String password;
	
	public Administrador() {}
	public Administrador(String pUsuario,String pPassword) {
		this.usuario=pUsuario;
		this.password=pPassword;
	}
	public String getUsuario() {return usuario;}
	public String getPassword() {return password;}
	
	public void setUsuario(String pUsuario ) {this.usuario=pUsuario;}
	public void setPassword(String pPassword ) {this.password=pPassword;}
	
	@Override
	public String toString() {
		return "Administrador [getUsuario()=" + getUsuario() + ", getPassword()=" + getPassword() + "]";
	}
	
	
	
	
}