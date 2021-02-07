package modelo.daoInterface;

import java.util.List;

import dominio.*;

public interface ServidorDAOInterface {

  	public Servidor altaS(Servidor s);
	public boolean bajaS(int idServidor);
	public boolean modificacionS(Servidor s);
	public Servidor consultaS(int idServidor);
	public List<Servidor> consultaAllS();
	 
 
}
