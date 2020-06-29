package com.revature.service;

import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.CustomerRepositoryJdbc;

public class CustomerServiceAlpha implements CustomerService {

	/* Singleton */
	private static CustomerService customerService = new CustomerServiceAlpha();
	
	private CustomerServiceAlpha() { }
	
	public static CustomerService getInstance() {
		return customerService;
	}
	
	@Override
	public boolean registerCustomer(Customer customer) {
		return CustomerRepositoryJdbc.getInstance().insert(customer);
	}

	@Override
	public boolean registerCustomerSecure(Customer customer) {
		return CustomerRepositoryJdbc.getInstance().insertProcedure(customer);
	}

	@Override
	public List<Customer> listAllCustomers() {
		return CustomerRepositoryJdbc.getInstance().selectAll();
	}

	@Override
	public Customer authenticate(Customer customer) {
		//Information on the database
		Customer loggedCustomer = CustomerRepositoryJdbc.getInstance().select(customer);
		
		/*
		 * What we have stored in the database is the Username + Password hash.
		 * We can't compare the blank password provided by the user, against the hash.
		 * So we have to obtain the hash of the user input.
		 * 
		 * If the hashes are the same, user is authenticated.
		 */
		if(loggedCustomer.getPassword().equals(CustomerRepositoryJdbc.getInstance().getCustomerHash(customer))) {
			return loggedCustomer;
		}
		
		return null;
	}

}
