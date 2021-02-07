package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import dominio.Servicio;
import model.Model.ModelSpringData;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModelSpringData modelo=  contexto.getBean(ModelSpringData.class);
		
		for (Servicio s :modelo.getServicios().findAll()) {
			modelo.getServicios().delete(s.getIdServicio());
			System.out.println("Borrado");
				
			
		}
		
	}

}
