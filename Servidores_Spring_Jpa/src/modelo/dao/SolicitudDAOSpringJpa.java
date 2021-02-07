package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.Solicitud;
import modelo.daoInterface.SolicitudDAOInterface;

@Repository
@Transactional
public class SolicitudDAOSpringJpa implements SolicitudDAOInterface{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Solicitud altaSo(Solicitud so) {
		try {em.persist(so);	} 
		catch (DataAccessException ex) {return null;}

		return so;
	

	}

	@Override
	public boolean bajaSo(int idSolicitud) {
		try {
			Solicitud u = this.consultaSo(idSolicitud);
		em.remove(u);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}

	@Override
	public boolean modificacionSo(Solicitud so) {
		try {
			em.merge(so);
			}
			catch (DataAccessException ex) {return false;}
			return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Solicitud consultaSo(int idSolicitud) {
		return em.find(Solicitud.class, idSolicitud);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<Solicitud> consultaAllSo() {
		Query query = em.createQuery("SELECT c FROM Solicitud c");
		List<Solicitud> todoslasSolicitudes = (List<Solicitud>) query.getResultList();
		return todoslasSolicitudes;
	}

}

