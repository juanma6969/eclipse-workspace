package modelo.modelo;

import java.util.ArrayList;
import java.util.List;

import dominio.Servidor;
import dominio.Solicitud;
import dominio.Usuario;
import modelo.daoInterface.*;
import modelo.modeloInterface.ModeloInterface;

public class ModeloSpringJpa implements ModeloInterface{
UsuarioDAOInterface usuarios;
SolicitudDAOInterface solicitudes;	
ServidorDAOInterface servidores;
	



	public void setUsuarios(UsuarioDAOInterface usuarios) {
	this.usuarios = usuarios;
}

public void setSolicitudes(SolicitudDAOInterface solicitudes) {
	this.solicitudes = solicitudes;
}

public void setServidores(ServidorDAOInterface servidores) {
	this.servidores = servidores;
}

	@Override
	public Usuario altaU(Usuario u) {
		// TODO Auto-generated method stub
		return usuarios.altaU(u);
	}

	@Override
	public Solicitud altaSo(Solicitud s) {
		// TODO Auto-generated method stub
		return solicitudes.altaSo(s);
	}

	@Override
	public Servidor altaS(Servidor se) {
		// TODO Auto-generated method stub
		return servidores.altaS(se);
	}

	@Override
	public boolean bajaU(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarios.bajaU(idUsuario);
	}

	@Override
	public boolean bajaSo(int idSolicitud) {
		// TODO Auto-generated method stub
		return solicitudes.bajaSo(idSolicitud);
	}

	@Override
	public boolean bajaS(int idServidor) {
		// TODO Auto-generated method stub
		return servidores.bajaS(idServidor);
	}

	@Override
	public boolean modificacionU(Usuario u) {
		// TODO Auto-generated method stub
		return usuarios.modificacionU(u);
	}

	@Override
	public boolean modificacionSo(Solicitud so) {
		// TODO Auto-generated method stub
		return solicitudes.modificacionSo(so);
	}

	@Override
	public boolean modificacionS(Servidor s) {
		// TODO Auto-generated method stub
		return servidores.modificacionS(s);
	}

	@Override
	public Usuario consultaU(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarios.consultaU(idUsuario);
	}

	@Override
	public Solicitud consultaSo(int idSolicitud) {
		// TODO Auto-generated method stub
		return solicitudes.consultaSo(idSolicitud);
	}

	@Override
	public Servidor consultaS(int idServidor) {
		// TODO Auto-generated method stub
		return servidores.consultaS(idServidor);
	}

	@Override
	public List<Usuario> consultaAllU() {
		// TODO Auto-generated method stub
		return usuarios.consultaAllU();
	}

	@Override
	public List<Solicitud> consultaAllSo() {
		// TODO Auto-generated method stub
		return solicitudes.consultaAllSo();
	}

	@Override
	public List<Servidor> consultaAllS() {
		// TODO Auto-generated method stub
		return servidores.consultaAllS();
	}

	@Override
	public Usuario consultaUP(String username, String passw) {
		List<Usuario> usuarios=this.consultaAllU();
		for(Usuario u: usuarios) {
			if(u.getNombre().equalsIgnoreCase(username)&& (u.getPassword().equalsIgnoreCase(passw))) {
				return u;
			}
		
		}
		return null;
	}

	@Override
	public List<Servidor> consultaByName(String q) {
		List<Servidor> servidores=this.consultaAllS();
		List<Servidor> servidoresCopy=new ArrayList<>();
		for(Servidor s: servidoresCopy) {
			if(s.getNombre().equals(q)) {
				servidoresCopy.add(s);
			}
		}
		return servidoresCopy;
	}

}
