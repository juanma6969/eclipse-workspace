package pfc.Principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import pfc.dominio.Clientes;
import pfc.modelo.*;
public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClienteDAOInterface clientes= (ClienteDAOInterface) contexto.getBean("clienteDAO");
		
		
		Clientes cliente;



		Clientes cliente1 = new Clientes("juan", "pwjuan", "Juan Alcaraz");
		Clientes cliente2 = new Clientes("pedro", "pwpedro", "Pedro Zamora");
		Clientes cliente3 = new Clientes("luis", "pwluis", "Luis Valera");
		
		// Borramos todo, para no tener que ejecutar el script de la base cada vez
		
		System.out.println();
		System.out.println("Alta de clientes en proceso");		
		clientes.alta(cliente1);
		clientes.alta(cliente2);
		clientes.alta(cliente3);
		
		System.out.println();
		System.out.println("Lista de clientes");
		for (Clientes c : clientes.consulta())
		System.out.println(c.getIdCliente() + "\t" + c.getPassword() + "\t\t" + c.getNombre());

		System.out.println();
		System.out.println("Baja de juan en proceso");	
		clientes.baja("juan");
		
		System.out.println();
		System.out.println("Lista de clientes");
		for (Clientes c : clientes.consulta()) 
		System.out.println(c.getIdCliente() + "\t" + c.getPassword() + "\t\t" + c.getNombre());
	
		System.out.println();
		System.out.println("Modificación de pedro en proceso");		
		cliente = clientes.consulta("pedro");
		cliente.setNombre("Pedro Zamóra Zamora");
		clientes.modificacion(cliente);
			
		System.out.println();
		System.out.println("Lista de clientes");
		for (Clientes c : clientes.consulta()) 
		System.out.println(c.getIdCliente() + "\t" + c.getPassword() + "\t\t" + c.getNombre());
		
		clientes.baja("pedro");
		clientes.baja("luis");
	}

}
