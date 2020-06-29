package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class CustomerControllerAlpha implements CustomerController {

	private static CustomerController customerController = new CustomerControllerAlpha();
	
	private CustomerControllerAlpha() {}
	
	public static CustomerController getInstance() {
		return customerController;
	}
	
	@Override
	public Object register(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "register.html";
		}

		/* Logic for POST */
		Customer customer = new Customer(0, request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("username"), request.getParameter("password"));

//		if (CustomerServiceAlpha.getInstance().registerCustomer(customer)) {
		if (CustomerServiceAlpha.getInstance().registerCustomerSecure(customer)) {
			return new ClientMessage("REGISTRATION SUCCESSFUL");
		} else {
			return new ClientMessage("SOMETHING WENT WRONG");
		}
	}

	@Override
	public Object getAllCustomers(HttpServletRequest request) {
		Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
		
		/* If customer is not logged in */
		if(loggedCustomer == null) {
			return "login.html";
		}
		
		/* Client is requesting the view. */
		if(request.getParameter("fetch") == null) {
			return "all-customers.html";
		} else {
		/* Client is requesting the list of customers */
			return CustomerServiceAlpha.getInstance().listAllCustomers();
		}
	}
}
