package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Servidor;
import dominio.Usuario;
import modelo.daoInterface.ServidorDAOInterface;


@Repository
@Transactional
public class ServidorDAOSpringJpa implements ServidorDAOInterface {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Servidor altaS(Servidor s) {
		try {em.persist(s);	} 
		catch (DataAccessException ex) {return null;}

		return s;
	}

	@Override
	public boolean bajaS(int idServidor) {
		try {
			Servidor u = this.consultaS(idServidor);
		em.remove(u);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}

	@Override
	public boolean modificacionS(Servidor s) {
		try {
			em.merge(s);
			}
			catch (DataAccessException ex) {return false;}
			return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Servidor consultaS(int idServidor) {
		// TODO Auto-generated method stub
		return em.find(Servidor.class, idServidor);
	}

	@Override
	public List<Servidor> consultaAllS() {
		Query query = em.createQuery("SELECT s FROM Servidor s");
		List<Servidor> todoslosServidores = (List<Servidor>) query.getResultList();
		return todoslosServidores;
	}

}
