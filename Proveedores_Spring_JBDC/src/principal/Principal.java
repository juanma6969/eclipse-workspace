package principal;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import capaModelo.modeloInterface.*;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;


public class Principal {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo = (ModeloInterface) context.getBean("modeloDAO");
			
				
			// Borramos todos los clientes en la tabla clientes
		for (Producto p : modelo.consultaAllpR()) {
			System.out.println(modelo.bajaPr(p.getIdProducto()));
		}

		
		for (Proveedor p : modelo.consultaAllP()) {
			System.out.println(modelo.bajaP(p.getIdProveedor()));
		}
		
		
		for (Compra c : modelo.consultaAllC()) {
			System.out.println(modelo.bajaC(c.getIdLinea()));
		}
		///Creacion de los productos provedores y las compras
		Producto aux=new Producto();
		
		Producto product1 = new Producto("Galletas "," Galletas Maria"); 
		Producto product2 = new Producto("Galletas 2 "," Galletas Juana"); 
		Producto product3 = new Producto("Galletas 3 "," Galletas Antonia"); 
	 int idP1;
	 int idP2;
	 int idP3;
	 System.out.println();
		System.out.println("Alta de clientes en proceso");		
		 product1=modelo.altaPr(product1);
		 idP1=product1.getIdProducto();
		 product2=modelo.altaPr(product2);
		 idP2=product2.getIdProducto();
		 product3=modelo.altaPr(product3);
		 idP3=product3.getIdProducto();
		 
		System.out.println("Registrado " + "Gallletas " + "con el id " + idP1);
		System.out.println("Registrado " + "Galletas " + "con el id " + idP2);
		System.out.println("Registrado " + "Galletas" + "con el id " + idP3);
			
			
			System.out.println();
		 
		 ///Creacion de proveedores

		
			Proveedor proveer1 = new Proveedor("Sun supermercados","+34 77737777 "," Fernando"); 
			Proveedor proveer2 = new Proveedor("Felix ","+34 666789214"," Fernando");
			Proveedor proveer3 = new Proveedor("Plaza de pedro","1212121221","Maria");
		 int idPv1;
		 int idPv2;
		 int idPv3;
		 System.out.println();
			System.out.println("Alta de proveedoresen proceso");		
			 proveer1=modelo.altaP(proveer1);
			 idPv1=proveer1.getIdProveedor();
			 proveer2=modelo.altaP(proveer2);
			 idPv2=proveer2.getIdProveedor();	
			 proveer3=modelo.altaP(proveer3);
			 idPv3=proveer3.getIdProveedor();	
			 
			 System.out.println("Registrado " + "Sun" + "con el id " + idPv1);
				System.out.println("Registrado " + "Felix " + "con el id " + idPv2);
				System.out.println("Registrado " + "Plaza" + "con el id " + idPv3);
				
				
				System.out.println();
				
				//Creacion Compras 
				 GregorianCalendar fecha1 = new GregorianCalendar(2010, 1, 6);
					GregorianCalendar fecha2 = new GregorianCalendar(1940, 5, 7);
					GregorianCalendar fecha3 = new GregorianCalendar(1987, 2, 26);
					 int idC1;
					 int idC2;
					 int idC3;
					
					Compra com1=new Compra(3,fecha1,12.50,product1,proveer1);
					Compra com2=new Compra(3,fecha2,12.50,product2,proveer2);
					Compra com3=new Compra(3,fecha3,12.50,product3,proveer3);
	            //   Compra com4=new Compra(9,fecha3,7.50,product3,proveer1);
					com1=modelo.altaC(com1);
	                idC1=com1.getIdLinea();
	                com2=modelo.altaC(com2);
	                idC2=com2.getIdLinea();
	                com3=modelo.altaC(com3);
	                idC3=com3.getIdLinea();
	             //   modelo.altaC(com4);
	              System.out.println("Registrado " + "Compra 1" + "con el id " + idC1);
				System.out.println("Registrado " + "Compra 2 " + "con el id " + idC2);
				System.out.println("Registrado " + "Compra 3" + "con el id " + idC3);
			
			/*	//Borramos una linea del producto
				System.out.println(modelo.bajaC(idC2));
				*/
			
			
			//Borramos una linea del proveedor
		//	System.out.println(modelo.bajaP(idPv2));
			
		  System.out.println(modelo.bajaPr(idP2));
		
			for(Proveedor p : modelo.consultaAllP()) {
				System.out.println(p);
			}
			System.out.println("\n");
			//Borramos una linea del producto
			
			
			 System.out.println();
			for(Producto p : modelo.consultaAllpR()) {
				System.out.println(p);
			}
			
			System.out.println("\n");
			for(Compra c : modelo.consultaAllC()) {
				System.out.println(c);
			}
			
		ArrayList<Compra> c=(ArrayList<Compra>) modelo.consulta(fecha3);
		System.out.println("Consulta por fecha");
		for (Compra c1  : c ) {
		
		System.out.println(c1);
	}
		ArrayList<Compra> c2=(ArrayList<Compra>) modelo.consultaResumenCompra(fecha3);
		System.out.println("Consulta Resumen por fecha");
		for (Compra c3  : c2 ) {
		
		System.out.println(c3);
	}
		
		
	}

}