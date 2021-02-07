package modelo.dao;

import java.util.List;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Usuario;
import modelo.daoInterface.UsuarioDAOInterface;

@Repository
@Transactional
public class UsuarioDAOSpringJpa implements UsuarioDAOInterface {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Usuario altaU(Usuario u) {
		try {em.persist(u);	} 
		catch (DataAccessException ex) {return null;}

		return u;
	}

	@Override
	public boolean bajaU(int idUsuario) {
		try {
			Usuario u = this.consultaU(idUsuario);
		em.remove(u);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}

	@Override
	public boolean modificacionU(Usuario u) {
		try {
			em.merge(u);
			}
			catch (DataAccessException ex) {return false;}
			return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario consultaU(int idUsuario) {
		return em.find(Usuario.class, idUsuario);
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> consultaAllU() {
		Query query = em.createQuery("SELECT u FROM Usuario u");
		List<Usuario> todoslosUsuarios = (List<Usuario>) query.getResultList();
		return todoslosUsuarios;
	}

	

}
