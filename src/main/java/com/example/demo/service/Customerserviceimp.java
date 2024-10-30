package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.repository.Customerrepository;
import com.example.demo.repository.Productrepository;
@Service
public class Customerserviceimp implements Customerservice{
@Autowired
private Customerrepository customerrepository;
@Autowired
private Productrepository productrepository;

	public Customerserviceimp(Customerrepository customerrepository, Productrepository productrepository) {
	super();
	this.customerrepository = customerrepository;
	this.productrepository = productrepository;
}

	@Override
	public String saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		customerrepository.save(c);
		return "customer details inserted";
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> l=customerrepository.findAll();
		return l;
	}
	public Customer assignProductToCustomer(Long pid, Long cid) {
		// TODO Auto-generated method stub
		Product product=productrepository.findById(pid).get();
		Customer customer=customerrepository.findById(cid).get();
		product.setCustomer(customer);
		productrepository.save(product);
		return customer;
	}
}
