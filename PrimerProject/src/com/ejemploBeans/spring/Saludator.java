package com.ejemploBeans.spring;

public class Saludator {
	private String mensaje;
	
public void  setSaludator(String pMsg) {
		this.mensaje=pMsg;
	}
	

	public String Saludator() {
	return (mensaje==null)?    "Hola mundo"   :  mensaje;
	
}
	
		


}
