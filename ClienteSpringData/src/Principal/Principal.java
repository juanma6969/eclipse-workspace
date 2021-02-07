package Principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ClienteRepositorio;
import dominio.Cliente;



public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClienteRepositorio clientes= (ClienteRepositorio) contexto.getBean("clienteRepositorio");
Cliente cliente=new Cliente();
cliente.setIdCliente("1");
cliente.setNombre("Juan");
cliente.setPassword("Examen");

clientes.save(cliente);
Cliente cliente2=new Cliente();
cliente2.setIdCliente("5");
cliente2.setNombre("Juan");
cliente2.setPassword("Examen");
clientes.save(cliente2);
/////
System.out.println(clientes.count());
System.out.println(clientes.findOne("1"));

	}

}
