package administrador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal {

	public static void main(String args[]) {

		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		Administrador administrador= (Administrador) contexto.getBean("administrador");
		
		System.out.println(administrador.toString());
	
	}

}
