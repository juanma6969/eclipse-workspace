package com.ejemploBeans.spring;

public class EmailService  {
	
	private Saludator saludator;
	
	public void setSaludator(Saludator pS) {
		this.saludator=pS;
	}
	public void enviarEmailSaludo(String destinatario) {
		System.out.println("Enviando email a " + destinatario);
		System.out.println("Mensaje: " +  saludator.Saludator());
	}
}
