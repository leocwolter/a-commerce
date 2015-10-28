package br.com.acommerce.infra;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@RequestScoped
public class MessageContainer {
	

	public void throwError(String errorKey) {
		ResourceBundle bundle = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msgs");  
		String messageError = bundle.getString(errorKey);  
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messageError, messageError));
	}

	public void addInfo(String infoKey) {
		addMessage(infoKey, FacesMessage.SEVERITY_INFO);
	}

	public void addError(String errorKey) {
		addMessage(errorKey, FacesMessage.SEVERITY_ERROR);
	}
	
	private void addMessage(String infoKey, Severity severityInfo) {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		ResourceBundle bundle = currentInstance.getApplication().getResourceBundle(currentInstance, "msgs");  
		String messageError = bundle.getString(infoKey);  
		currentInstance.addMessage(null, new FacesMessage(severityInfo, messageError, messageError));
	}
}
