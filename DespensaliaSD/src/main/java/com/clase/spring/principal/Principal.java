package com.clase.spring.principal;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clase.spring.dominio.Cliente;
import com.clase.spring.dominio.Pedido;
import com.clase.spring.modelo.modeloDAO.ModeloDao;
import com.clase.spring.modelo.modeloInterface.ModeloInterface;


public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo= (ModeloDao)contexto.getBean("beanSpringModelo");
	

	Cliente cliente1=new Cliente("Jose09","Jose Francisco","Fernandez Gutierrez","678200099","jose@gmail.com");
	Cliente cliente2=new Cliente("JoseMa99","Jose Manuel ","Gomez Sanchez","678200099","josefen@gmail.com");
	Cliente cliente3=new Cliente("JoseMa89","Jose Felix ","Gomez Sanchez","678200099","josefen77@gmail.com");
	System.out.println(modelo.alta(cliente1));
	System.out.println(modelo.alta(cliente2));
	System.out.println(modelo.alta(cliente3));
	//Fechas de Recogida
	 Calendar fechaP1=new GregorianCalendar();
	 Calendar fechaP2=new GregorianCalendar();
	 Calendar fechaP3=new GregorianCalendar();
	//Fechas de Recogida
 Calendar fechaR1=new GregorianCalendar(2021,8,15);
 Calendar fechaR2=new GregorianCalendar(2021,8,13);
 Calendar fechaR3=new GregorianCalendar(2021,8,14);
	//Alta de pedido
	Pedido pedido1=new Pedido(cliente1,fechaP1,fechaR1,60.0,"Mas salsa");
	Pedido pedido2=new Pedido(cliente2,fechaP2,fechaR2,78.0,"Mas salsa");
	Pedido pedido3=new Pedido(cliente3,fechaP3,fechaR3,60.0,"Mas salsa");
	System.out.println(modelo.alta(pedido1));
	System.out.println(modelo.alta(pedido2));
	System.out.println(modelo.alta(pedido3));
	for(Cliente c:modelo.clientesAll()) {
		System.out.println(c.toString());
	}
	for(Pedido p:modelo.pedidosAll()) {
		System.out.println(p.toString());
	}
	}

}
