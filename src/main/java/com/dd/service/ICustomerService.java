package com.dd.service;

import java.util.List;



import com.dd.exception.CustomerNotFoundException;
import com.dd.model.Customer;


public interface ICustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFoundException;
	public List<Customer> viewAllCustomer();
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException;
}
