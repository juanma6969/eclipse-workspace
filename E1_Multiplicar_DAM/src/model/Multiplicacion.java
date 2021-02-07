package model;

import java.io.Serializable;

public class Multiplicacion implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String multiplicacion;
private String resultado;


public Multiplicacion(String multi,String resultado) {
	super();
	this.multiplicacion=multi;
	this.resultado=resultado;
}


public String getMultiplicacion() {
	return multiplicacion;
}


public void setMultiplicacion(String multiplicacion) {
	this.multiplicacion = multiplicacion;
}


public String getResultado() {
	return resultado;
}


public void setResultado(String resultado) {
	this.resultado = resultado;
}

public boolean isCorrect(String response) {
	return response.trim().equals(resultado);
}


}
