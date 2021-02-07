package controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import model.Multiplicacion;



@FacesValidator("controller.OperacionV")
public class OperacionValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		 if(value == null) return;
	      String operation;
	      if (value instanceof Multiplicacion)
	         operation = value.toString();
	      else 
	         operation = value.toString().replaceAll("\\D", ""); // remove non-digits
	     
	      if(!luhnCheck(operation)) {
	         FacesMessage message 
	            = util.Messages.getMessage(
	               "controller.messages", "badLuhnCheck", null);
	         message.setSeverity(FacesMessage.SEVERITY_ERROR);
	         throw new ValidatorException(message);
	      }
	}
	  private static boolean luhnCheck(String cardNumber) {
	   
return false;	

	      
	   }
	}


