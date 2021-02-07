package com.openwebinars.javaconfig.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.openwebinars.javaconfig.appConfig.AppConfig;
import com.openwebinars.javaconfig.modelo.PeliculaService;

public class App {

	public static void main(String[] args) {
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PeliculaService peliculaService = appContext.getBean(PeliculaService.class);
		
		peliculaService.pelisPorGenero("Ciencia ficción").forEach(System.out::println);
				
		((AnnotationConfigApplicationContext) appContext).close();
	}

}
