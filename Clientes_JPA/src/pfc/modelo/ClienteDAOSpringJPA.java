package pfc.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pfc.dominio.Clientes;
@Repository
@Transactional
public class ClienteDAOSpringJPA implements ClienteDAOInterface {

	@PersistenceContext
	private EntityManager em;

	public boolean alta(Clientes c) {

		try {em.persist(c);	} 
		catch (DataAccessException ex) {return false;}

		return true;
	}


	public void baja(String idCliente) {
		Clientes c = this.consulta(idCliente);
		em.remove(c);
	};
	

	public void modificacion(Clientes c) {em.merge(c);}

	@Transactional(readOnly=true)
	public Clientes consulta(String idCliente) {
		return em.find(Clientes.class, idCliente);
	}
	
	@Transactional(readOnly=true)
	public List<Clientes> consulta() {
		Query query = em.createQuery("SELECT c FROM Clientes c");
		List<Clientes> todoslosClientes = (List<Clientes>) query.getResultList();
		return todoslosClientes;
	}
}
