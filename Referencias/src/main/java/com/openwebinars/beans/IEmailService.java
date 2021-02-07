package com.openwebinars.beans;

public interface IEmailService {
public void setDestinatarioPorDefault(String destinatario);
public void enviarEmailSaludo(String destinatario);
public void enviarEmailSaludo();
}
