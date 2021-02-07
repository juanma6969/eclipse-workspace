package com.openwebinars.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		ApplicationContext appContext=new ClassPathXmlApplicationContext("beans.xml");
		
		
		IEmailService emailService1=appContext.getBean(IEmailService.class);
		emailService1.setDestinatarioPorDefault("Joseaaaaaa");
		emailService1.enviarEmailSaludo();
		
		
		IEmailService emailService2=null;
		emailService2=appContext.getBean(IEmailService.class);
		emailService2.enviarEmailSaludo();
		
		
		((ClassPathXmlApplicationContext)appContext).close();
	}

}
