package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface LoginController {

	/**
	 * If the method is GET, it will return the login view.
	 * 
	 * If the method is POST.
	 * -> If service layer returns null, we return a message
	 * stating that authentication failed.
	 * 
	 * -> Else, it will return the Customer information
	 * (and store it in the session).
	 */
	public Object login(HttpServletRequest request);
	
	/**
	 * Invalidates the session and returns the login view.
	 */
	public String logout(HttpServletRequest request);
}
