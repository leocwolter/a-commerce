package br.com.acommerce.infra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Flash {

	private static final String ERRORS_KEY = "errors";

	public static void addError(String error, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Errors errors = getErrors(session);
		if(errors == null) errors = new Errors();
		errors.add(error);
		session.setAttribute(ERRORS_KEY, errors);
	}

	public static void updateErrors(HttpServletRequest req) {
		getErrors(req.getSession()).secondRequest();
	}

	public static boolean isFirstRequest(HttpServletRequest req) {
		return getErrors(req.getSession()).isFirstRequest();
	}

	private static Errors getErrors(HttpSession session) {
		Errors errors = (Errors) session.getAttribute(ERRORS_KEY);
		return errors;
	}

	public static void cleanErrors(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute(ERRORS_KEY, null);
		
	}

	public static boolean hasErrors(HttpServletRequest req) {
		Errors errors = getErrors(req.getSession());
		return errors != null && !errors.getMessages().isEmpty(); 
	}



}
