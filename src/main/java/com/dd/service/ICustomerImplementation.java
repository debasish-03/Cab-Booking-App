package com.dd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.exception.CustomerNotFoundException;
import com.dd.model.Customer;
import com.dd.repository.ICustomerRepository;

@Service
public class ICustomerImplementation implements ICustomerService {

	@Autowired
	private ICustomerRepository iCustomerRepository;
	
	@Override
	public Customer insertCustomer(Customer customer) {
		return iCustomerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException {
		Customer existingCustomer = iCustomerRepository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer", "Id", id));
		
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		
		iCustomerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFoundException {
		Customer existingCustomer = iCustomerRepository.findById(customerId).orElseThrow(
				() -> new CustomerNotFoundException("Customer", "Id", customerId));
		iCustomerRepository.deleteById(customerId);
		return existingCustomer;
	}

	@Override
	public List<Customer> viewAllCustomer() {	
		return iCustomerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		Customer existingCustomer = iCustomerRepository.findById(customerId).orElseThrow(
				() -> new CustomerNotFoundException("Customer", "Id", customerId));
		return existingCustomer;
	}

	@Override
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException {
		Customer customer = iCustomerRepository.findByUserNameAndPassword(username, password);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer", "username", username);
		}
		return customer;
	}

}
