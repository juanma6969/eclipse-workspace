package pfc.principal;

import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pfc.dao.ClienteDAOInterface;
import pfc.dao.ServicioDAOInterface;
import pfc.dominio.Cliente;
import pfc.dominio.Servicio;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
ClienteDAOInterface clientes = (ClienteDAOInterface) context.getBean("clientesDAO");
		ServicioDAOInterface servicios = (ServicioDAOInterface) context.getBean("serviciosDAO");
		
	// Borramos todos los clientes en la tabla clientes
		
	
		// Borramos todos los servicios en la tabla servicios
		for (Servicio s : servicios.consultaAll()) {
			System.out.println(servicios.baja(s.getIdServicio()));
		}

		
	for (Cliente c : clientes.consultaAllC()) {
			System.out.println(clientes.baja(c.getIdCliente()));
		}
		// Creacion de Clientes y alta
		Cliente auxCliente = new Cliente();

		Cliente cliente1 = new Cliente("Murcia",  "Juan@prueba.com","Murcia");
		Cliente cliente2 = new Cliente ("Alicante","Pedro@prueba.com","Pedro" );
		Cliente cliente3 = new Cliente( "Madrid","Luis@prueba.com","Luis" );
		int idC1;
		int idC2;
		int idC3;

		
		System.out.println();
		System.out.println("Alta de clientes en proceso");		
		
		 cliente1 = clientes.alta(cliente1);
		idC1 = cliente1.getIdCliente();
		
		cliente2 = clientes.alta(cliente2);
	idC2 = cliente2.getIdCliente();
		
		cliente3 = clientes.alta(cliente3);
		idC3 = cliente3.getIdCliente();
		
		
		System.out.println("Registrado " + "Juan " + "con el id " + idC1);
		System.out.println("Registrado " + "Pedro " + "con el id " + idC2);
		System.out.println("Registrado " + "Luis " + "con el id " + idC3);
		
		
		System.out.println();

	// Creacion de servicios y alta
		GregorianCalendar fecha1 = new GregorianCalendar(1990, 1, 6);
		GregorianCalendar fecha2 = new GregorianCalendar(1940, 5, 7);
		GregorianCalendar fecha3 = new GregorianCalendar(1977, 2, 26);
		
	Servicio auxServicio = new Servicio();
		
		Servicio servicio1 = new Servicio("Renta",fecha1,150, cliente1);
	Servicio servicio2 = new Servicio("Gestion bancaria",fecha2,1222, cliente2);
		Servicio servicio3 = new Servicio("Gestion Fiscal",fecha3,900, cliente3);
		Servicio servicio4 = new Servicio("Gestion bancaria",fecha2,1222, cliente1);
		servicio1=servicios.alta(servicio1);
		System.out.println(servicio1);
	
		int idS1;
		int idS2;
		int idS3;
		
		
		System.out.println();
		System.out.println("Registro de servicios en proceso");		
		
		servicio1 = servicios.alta(servicio1);
		idS1 = servicio1.getIdServicio();
		
		servicio2 = servicios.alta(servicio2);
		idS2 = servicio2.getIdServicio();
		
		servicio3 = servicios.alta(servicio3);
		idS3 = servicio3.getIdServicio();
		
		
		System.out.println("Registrado " + "Renta " + "con el id " + idS1);
		System.out.println("Registrado " + "Gestion bancaria " + "con el id " + idS2);
		System.out.println("Registrado " + "Gestion Fiscal " + "con el id " + idS3);
		
		servicio1 = servicios.alta(servicio4);
		idS1 = servicio1.getIdServicio();
		
	System.out.println("Registrado " + "Gestion bancaria " + "con el id " + idS1);
		
		System.out.println();
		
		
		// Prueba de metodos de Cliente
		
		System.out.println("Lista de clientes con servicios");
		for (Cliente c : clientes.consultaAllC())
		System.out.println(c);

		System.out.println();
		System.out.println("Baja de juan en proceso");	
		clientes.baja(idC1);
		
		System.out.println();
		System.out.println("Lista de clientes con servicios");
		for (Cliente c : clientes.consultaAllC()) 
		System.out.println(c);
	
		System.out.println();
		System.out.println("Modificación de pedro en proceso");		
		auxCliente = clientes.consulta(idC2);
		auxCliente.setNombre("Pedro Zamora Zamora");
		clientes.modificacion(auxCliente);
			
		System.out.println();
		System.out.println("Lista de clientes con servicios");
		for (Cliente c : clientes.consultaAllC()) 
		System.out.println(c);
		
		
		// Prueba metodos Servicio

		
		System.out.println("Lista de servicios con clientes");
		for (Servicio s : servicios.consultaAll())
		System.out.println(s);

		System.out.println();
		System.out.println("Baja de servicio 3");	
		//servicios.baja(idS3);
		
		System.out.println();
		System.out.println("Lista de servicios con clientes");
		for (Servicio s : servicios.consultaAll())
		System.out.println(s);
	
		System.out.println();
		System.out.println("Modificación de servicio Gestion");		
		//auxServicio = servicios.consulta(idS2);
		auxServicio.setDescripcion("Gestion empresarial");
		servicios.modificacion(auxServicio);
			
		System.out.println();
		System.out.println("Lista de servicios con clientes");
		for (Servicio s : servicios.consultaAll())
		System.out.println(s);
		
		
	}

}