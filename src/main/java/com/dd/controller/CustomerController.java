package com.dd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.model.Customer;
import com.dd.service.ICustomerService;

@Controller
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("save")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(iCustomerService.insertCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("update/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {
		try {
			iCustomerService.updateCustomer(customerId, customer);
			return new ResponseEntity<String>("Customer updated Sucessfully.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Error while updating customer details.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId) {
		try {
			iCustomerService.deleteCustomer(customerId);
			return new ResponseEntity<String>("Customer deleted Successfully.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Error while deleting customer data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("all/")
	public List<Customer> getAllCustomer() {
		return iCustomerService.viewAllCustomer();
	}
	
	@PostMapping("login")
	public ResponseEntity<String> loginUser(@RequestBody Customer customer) {
		try {
			iCustomerService.validateCustomer(customer.getUsername(), customer.getPassword());
			return new ResponseEntity<String>("Login Successful", HttpStatus.OK);	
		} catch(Exception e) {
			return new ResponseEntity<String>("Login Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
