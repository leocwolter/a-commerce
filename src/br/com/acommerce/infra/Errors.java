package br.com.acommerce.infra;

import java.util.ArrayList;
import java.util.List;

public class Errors {

	private boolean firstRequest = true;
	private List<String> errors = new ArrayList<>();
	
	public void add(String error) {
		errors.add(error);
	}

	public void secondRequest() {
		firstRequest = false;
	}

	public boolean isFirstRequest() {
		return firstRequest;
	}

	public List<String> getMessages() {
		return errors;
	}

}
