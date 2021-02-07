package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="operacion")
@SessionScoped
public class OperacionController {
private String opNO,opNT,result,resultC,showT;
private List<String> listaOp;

public OperacionController() {
	listaOp=new ArrayList<>();
	listaOp.add("1");
	for(Integer i=0;i<listaOp.size();i++) {
		listaOp.add(""+i);
	}
}
public List<String> getlistaOp() {
	return listaOp;
}


public void setlistaOp(List<String> listaOp) {
	this.listaOp = listaOp;
}











public String getOpNT() {
	return opNT;
}
public void setOpNT(String opNT) {
	this.opNT = opNT;
}
public String getOpNO() {
	return opNO;
}
public void setOpNO(String opNO) {
	this.opNO = opNO;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String getResultC() {
	return result;
}
public void setResultC(String resultC) {
	this.resultC = resultC;
}
public String validaMulti() {
	resultC=""+(Integer.parseInt(opNO)*Integer.parseInt(opNT));


	if(resultC.trim().equals(result)) {
		return "success";
	}else {
		return "failure";
	}
}




public String getShowT() {
	return showT=this.CalculoTabla();
}
public void setShowT(String showT) {
	this.showT = showT;
}
public String CalculoTabla() {
	StringBuilder m=new StringBuilder();
	int op1=Integer.parseInt(opNO);
	Integer[] arrayCalc=new Integer[11];
	

	for(int i=0;i<=10;i++) {
		arrayCalc[i]=op1*i;
		m.append(op1+"*"+i+"="+arrayCalc[i]+",");
		}
	return m.toString();
}
}
