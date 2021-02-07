package com.clase.spring.modelo.data;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Pedido;

@Repository
public interface PedidoRepositorio extends CrudRepository<Pedido,Integer>{

	//@Query(value = "SELECT * FROM TPedidos WHERE IdCliente = ?1 AND FRecogida = ?2", nativeQuery = true)
	/*Pedido findBytclienteAndfHRecogida(Cliente tcliente, GregorianCalendar fHRecogida);
	
	ArrayList<Pedido> findByfHRecogida(GregorianCalendar fHRecogida);
*/
}
