package com.dd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dd.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "select * from customer c where c.username = ?1 and c.password = ?2", nativeQuery = true)
	Customer findByUserNameAndPassword(String username,String password);
}
