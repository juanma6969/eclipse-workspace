package principal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.Servidor;
import dominio.Solicitud;
import dominio.Usuario;
import modelo.modeloInterface.ModeloInterface;



public class Principal {

	public static void main(String[] args) {
		
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo= (ModeloInterface) contexto.getBean("modelo");
		
		
		// Borramos todos los clientes en la tabla clientes
			
	
			// Borramos todos los servicios en la tabla servicios
			for (Usuario u : modelo.consultaAllU()) {
				System.out.println(modelo.bajaU(u.getId()));
			}
/*
			
		for (Solicitud so : modelo.consultaAllSo()) {
				System.out.println(modelo.bajaSo(so.getId()));
			}
		for (Servidor s : modelo.consultaAllS()) {
			System.out.println(modelo.bajaSo(s.getId()));
		}*/
			// Creacion de Clientes y alta
			Usuario auxUsuario = new Usuario();

			Usuario u1=new Usuario("Jose Manuel","juanma1456.jg@","Josefelix","admin","soltero");
			Usuario u2=new Usuario("Jose Manuel","juanma1456.jg@","Jose1","admin","soltero");
			Usuario u3=new Usuario("Jose Manuel","juanma1456.jg@","Jose1","admin","soltero");
			int idU1;
			int idU2;
			int idU3;

			
			System.out.println();
			System.out.println("Alta de clientes en proceso");		
			
			u1 = modelo.altaU(u1);
			idU1 = u1.getId();
			
			u2 = modelo.altaU(u2);
			idU2 = u2.getId();
					u3 = modelo.altaU(u3);
			idU3 = u3.getId();
			
			
			System.out.println("Registrado " + "Juan " + "con el id " + idU1);
			System.out.println("Registrado " + "Pedro " + "con el id " + idU2);
			System.out.println("Registrado " + "Luis " + "con el id " + idU3);
			Usuario aux=modelo.consultaUP("JoseFelix", "admin");
			
			System.out.println( aux);
			System.out.println();
			Servidor se1=new Servidor();
			
			
			
			
			// Creacion de Clientes y alta
			Solicitud auxSolicitud = new Solicitud();
Date fecha1=new Date();
			Solicitud s1=new Solicitud(fecha1,"Jose Manuel","juanma1456.jg@","Jose1","admin","soltero",se1,u1);
			
		
			
			
			
	}

}
