package com.openwebinars.beans;

public class EmailService  implements IEmailService{
private Saludator saludator;
private String destinatarioPorDefault;

public void enviarEmailSaludo(String destinatario) {
	
	System.out.println("Enviando email a" + destinatario);
	System.out.println("Mensaje : " + saludator.getSaludo());
}


public void setSaludator(Saludator saludator) {
	this.saludator = saludator;
}
public String getDestinatarioPorDefault() {
	return destinatarioPorDefault;
}

public void setDestinatarioPorDefault(String destinatario) {
	this.destinatarioPorDefault = destinatario;
}

@Override
public void enviarEmailSaludo() {
	if(this.destinatarioPorDefault!=null) {
		enviarEmailSaludo(this.destinatarioPorDefault);
	}else {
		System.out.println("Configure un destinatario");
	}
}







}
