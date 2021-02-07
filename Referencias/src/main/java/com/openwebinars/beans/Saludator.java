package com.openwebinars.beans;

public class Saludator {
	private String saludo;
	

	public String getSaludo() {
		return (saludo==null) ? "Hola mundo " : saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo.toUpperCase();
	}

}
