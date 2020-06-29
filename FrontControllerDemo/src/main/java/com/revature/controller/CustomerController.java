package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface CustomerController {
	
	/**
	 * Registers the user.
	 * 
	 * -> If the method is GET, return the registration view.
	 * -> Else, return a message stating that registration was successful, or not.
	 */
	public Object register(HttpServletRequest request);
	
	/**
	 * Get all customers in the database.
	 * 
	 * -> If it's GET with no parameters, then we return the view.
	 * -> If it's GET with a paramter, then we return the list of users.
	 */
	public Object getAllCustomers(HttpServletRequest request);
}
