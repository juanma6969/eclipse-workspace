package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.modeloInterface.ModeloInterface;

public class SolicitudController {
	  ApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContext.xml");
		ModeloInterface modelo= (ModeloInterface) contexto.getBean("modelo");


}
