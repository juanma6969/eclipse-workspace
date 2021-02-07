package modelo.modeloInterface;

import java.util.List;

import dominio.Servidor;
import dominio.Solicitud;
import dominio.Usuario;

public interface ModeloInterface {
	
	public Usuario altaU(Usuario u);
	public Solicitud altaSo(Solicitud s);
	public Servidor altaS(Servidor se);
	
	public boolean bajaU(int idUsuario);
	public boolean bajaSo(int idSolicitud);
	public boolean bajaS(int idServidor);
	
	public boolean modificacionU(Usuario u);
	public boolean  modificacionSo(Solicitud so);
	public boolean  modificacionS(Servidor s);
	
	public Usuario consultaU(int idUsuario);
	public Solicitud consultaSo(int idSolicitud);
	public Servidor consultaS(int idServidor);
	//Para saber si un usuario esta logueado
	public Usuario consultaUP(String username,String passw );
	
	
	public List<Usuario> consultaAllU();
    public List<Solicitud> consultaAllSo();
    public List<Servidor> consultaAllS();
  //Para realizar la busqueda por nombre
  	public List<Servidor> consultaByName(String q);
}
