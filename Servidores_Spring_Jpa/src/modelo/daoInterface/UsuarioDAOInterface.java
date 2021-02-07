package modelo.daoInterface;

import java.util.List;

import dominio.Usuario;

public interface UsuarioDAOInterface {
	public Usuario altaU(Usuario u);
	public boolean bajaU(int idUsuario);
	public boolean modificacionU(Usuario u);
	public Usuario consultaU(int idUsuario);
	public List<Usuario> consultaAllU();

}
