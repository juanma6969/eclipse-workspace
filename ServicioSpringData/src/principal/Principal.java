package principal;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import data.ClienteRepositorio;
import data.ServicioRepositorio;
import dominio.Cliente;
import dominio.Servicio;




public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClienteRepositorio clientes= (ClienteRepositorio) contexto.getBean("clienteRepositorio");
		ServicioRepositorio servicios=(ServicioRepositorio) contexto.getBean("servicioRepositorio");
		for (Servicio s :servicios.findAll()) {
			servicios.delete(s.getIdServicio());
			System.out.println("Borrado");
				
			
		}
for (Cliente c : clientes.findAll()) {
			clientes.delete(c.getIdCliente());
		}
Cliente auxCliente=new Cliente();
Cliente cliente1 = new Cliente("Murcia",  "Juan@prueba.com","Juan");
Cliente cliente2 = new Cliente ("Alicante","Pedro@prueba.com","Pedro" );
Cliente cliente3 = new Cliente( "Madrid","Luis@prueba.com","Luis" );
int idC1;
int idC2;
int idC3;
cliente1=clientes.save(cliente1);
idC1 = cliente1.getIdCliente();
cliente2=clientes.save(cliente2);
idC2 = cliente2.getIdCliente();
cliente3=clientes.save(cliente3);
idC3= cliente1.getIdCliente();
System.out.println("Registrado " + "Juan " + "con el id " + idC1);
System.out.println("Registrado " + "Pedro " + "con el id " + idC2);
System.out.println("Registrado " + "Luis " + "con el id " + idC3);

Calendar fecha1 = new GregorianCalendar(1990, 1, 6);
Calendar fecha2 = new GregorianCalendar(1940, 5, 7);
Calendar fecha3 = new GregorianCalendar(1977, 2, 26);
Servicio  auxServicio=new Servicio();
Servicio servicio1 = new Servicio("Renta",fecha1,150, cliente1);
Servicio servicio2 = new Servicio("Gestion bancaria",fecha2,1222, cliente2);
	Servicio servicio3 = new Servicio("Gestion Fiscal",fecha3,900, cliente3);
	//Servicio servicio4 = new Servicio("Gestion bancaria",fecha2,1222, cliente1);
	
int idS1;
	int idS2 = 0;
	int idS3;
	servicio1=servicios.save(servicio1);
	idS1 = servicio1.getIdServicio();
	servicio2=servicios.save(servicio2);
	idS2 = servicio2.getIdServicio();
	servicio3=servicios.save(servicio3);
	idS3 = servicio3.getIdServicio();
	
	System.out.println("Lista de clientes con servicios");
	for (Cliente c : clientes.findAll())
		System.out.println(c);
	
	System.out.println();
	System.out.println("Modificación de pedro en proceso");		
	auxCliente = clientes.findOne(idC2);
	auxCliente.setNombre("Pedro Zamora Zamora");
	clientes.save(auxCliente);
		
	System.out.println();
	System.out.println("Lista de clientes con servicios");
	
	for (Cliente c : clientes.findAll()) 
		System.out.println(c);

	System.out.println("Lista de servicios con clientes");
	for (Servicio s : servicios.findAll())
		System.out.println(s);
	System.out.println();
	
	
	System.out.println("Modificación de servicio Gestion");		
	auxServicio =servicios.findOne(idS2);
	auxServicio.setDescripcion("Gestion empresarial");
	servicios.save(auxServicio);
		
	System.out.println();
	System.out.println("Lista de servicios con clientes");
	for (Servicio s : servicios.findAll())
		System.out.println(s);
	}
	
	
	}


