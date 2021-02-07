package principal;

import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;
import modeloInterface.modeloInterface;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		modeloInterface modelo = (modeloInterface) context.getBean("modelo");
		
//		for (Proveedor p : modelo.consultaAllP()) {
//			modelo.bajaP(p.getIdProveedor());
//		}
//		
//		for (Producto pr : modelo.consultaAllPr()) {
//			modelo.bajaPr(pr.getIdProducto());
//		}
//		
//		for (Compra c : modelo.consultaAllC()) {
//			modelo.bajaC(c.getIdCompra());
//		}
		
		Proveedor auxProveedor = new Proveedor();
		
		Proveedor proveedor1 = new Proveedor("Alvaro",649659021,"Montepinar");
		Proveedor proveedor2 = new Proveedor("Javier",672310787,"Llano");
		Proveedor proveedor3 = new Proveedor("Maria",631323342,"Santa");
		int idP1;
		int idP2;
		int idP3;
		
		System.out.println();
		System.out.println("Alta de proveedores en proceso");	
		
		proveedor1 = modelo.alta(proveedor1);
		idP1 = proveedor1.getIdProveedor();
		proveedor2 = modelo.alta(proveedor2);
		idP2 = proveedor2.getIdProveedor();
		proveedor3 = modelo.alta(proveedor3);
		idP3 = proveedor3.getIdProveedor();
		
		System.out.println("Registrado " + "Alvaro " + "con el id " + idP1);
		System.out.println("Registrado " + "Javier " + "con el id " + idP2);
		System.out.println("Registrada " + "Maria " + "con el id " + idP3);
		
		
		System.out.println();
		
		Producto auxProducto = new Producto();
		
		Producto producto1 = new Producto("Pelota","Redonda como ninguna");
		Producto producto2 = new Producto("Lapiz","De madera fina");
		Producto producto3 = new Producto("Gafa","De la mejor pasta");
		Producto producto4 = new Producto("Chaqueta","La que mas abriga");
		int idPr1;
		int idPr2;
		int idPr3;
		int idPr4;
		
		System.out.println();
		System.out.println("Alta de productos en proceso");
		
		producto1 = modelo.alta(producto1);
		modelo
		idPr1 = producto1.getIdProducto();
		producto2 = modelo.alta(producto2);
		idPr2 = producto2.getIdProducto();
		producto3 = modelo.alta(producto3);
		idPr3 = producto3.getIdProducto();
		producto4 = modelo.alta(producto4);
		idPr4 = producto4.getIdProducto();
		
		System.out.println("Registrado " + "Pelota " + "con el id " + idPr1);
		System.out.println("Registrado " + "Lapiz " + "con el id " + idPr2);
		System.out.println("Registrado " + "Gafa" + "con el id " + idPr3);
		System.out.println("Registrado " + "Chaqueta " + "con el id " + idPr4);
		
		System.out.println();
		
		GregorianCalendar fecha1 = new GregorianCalendar(1990, 1, 6);
		GregorianCalendar fecha2 = new GregorianCalendar(1940, 5, 7);
		GregorianCalendar fecha3 = new GregorianCalendar(1977, 2, 26);
		
		Compra auxCompra = new Compra();
		
		Compra compra1 = new Compra(2,fecha1,2.5,proveedor1,producto1);
		Compra compra2 = new Compra(5,fecha2,5,proveedor2,producto2);
		Compra compra3 = new Compra(3,fecha3,10.1,proveedor3,producto3);
		Compra compra4 = new Compra(10,fecha1,1,proveedor1,producto4);
		int idC1;
		int idC2;
		int idC3;
		int idC4;
		
		System.out.println();
		System.out.println("Alta de compras en proceso");
		
		compra1 = modelo.alta(compra1);
		idC1 = compra1.getIdCompra();
		compra2 = modelo.alta(compra2);
		idC2 = compra2.getIdCompra();
		compra3 = modelo.alta(compra3);
		idC3 = compra3.getIdCompra();
		compra4 = modelo.alta(compra4);
		idC4 = compra4.getIdCompra();
		
		System.out.println("Registrada " + "Compra " + "con el id " + idC1);
		System.out.println("Registrada " + "Compra " + "con el id " + idC2);
		System.out.println("Registrada " + "Compra" + "con el id " + idC3);
		System.out.println("Registrada " + "Compra" + "con el id " + idC4);
		
		System.out.println();
	}

}
