package java.com.corejsf;

import java.io.Serializable;

public class Problem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pregunta;
	private String respuesta;
	public Problem(String pPregunta,String pRespuesta) {
		this.pregunta=pPregunta;
		this.respuesta=pRespuesta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public boolean isCorrect(String response) {
		return response.trim().equalsIgnoreCase(respuesta);
	}

}
