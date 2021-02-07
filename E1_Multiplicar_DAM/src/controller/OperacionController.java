package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Multiplicacion;

@ManagedBean(name="operacion")
@SessionScoped
public class OperacionController {
private ArrayList<Multiplicacion> lMulti=new ArrayList<Multiplicacion>(Arrays.asList(new Multiplicacion("2*2 ","4"),
		new Multiplicacion("2*3","6"),
		new Multiplicacion("2*8","16"),
		new Multiplicacion("6*10","60"),
		new Multiplicacion("5*4","20"),
		new Multiplicacion("6*5","30"),
		new Multiplicacion("5*8","40"),
		new Multiplicacion("1*2","2")));
	private int currentMulti;
	private String respuesta="";
private String respuestaCorrect;
private String showT;
	 public String getMulti() { return lMulti.get(currentMulti).getMultiplicacion(); }

	   public String getAnswer() { return respuestaCorrect ; }
	  
	   public String getShowT() {
		return showT=this.CalculoTabla();
	}

	public void setShowT(String showT) {
		this.showT = showT;
	}

	public String answerAction() {
		    
		      if (lMulti.get(currentMulti).isCorrect(respuesta)) {
		
		         nextProblem();
		         if (currentMulti == lMulti.size()) return "done";
		         else return "success";
		      }
		  // else if (currentMulti == 1) return "again";
		      else {
		         nextProblem();
		         if (currentMulti == lMulti.size()) return "done";
		         else return "failure";
		      }
		   }
	
	   
	   
	   public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String startOverAction() {
		      Collections.shuffle(lMulti);
		      currentMulti = 0;
		      respuesta = "";
		      return "startOver";
		   }
	
	public String CalculoTabla() {
		StringBuilder m=new StringBuilder();
		String[] arrayM=lMulti.get(currentMulti).getMultiplicacion().split("\\*");
		int op1=Integer.parseInt(arrayM[0]);
		Integer[] arrayCalc=new Integer[11];
		

		for(int i=0;i<=10;i++) {
			arrayCalc[i]=op1*i;
			m.append(op1+"*"+i+"="+arrayCalc[i]);
			}
		return m.toString();
	}
	private void nextProblem() {
	      this.respuestaCorrect = lMulti.get(currentMulti).getResultado();
	      currentMulti++;
	      respuesta = "";
	   }
}
