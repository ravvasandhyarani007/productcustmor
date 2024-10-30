package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.service.Customerserviceimp;

@RestController
@RequestMapping("/api/customer")
public class Customercontroller {
@Autowired
private Customerserviceimp customerserviceimp;

public Customercontroller(Customerserviceimp customerserviceimp) {
	super();
	this.customerserviceimp = customerserviceimp;
}
@PostMapping("/addcustomer")
public ResponseEntity<String> saveCustomer(@RequestBody Customer c){
	customerserviceimp.saveCustomer(c);
	return new ResponseEntity<>("customer details inserted",HttpStatus.CREATED);
}
@GetMapping("/detail")
public List<Customer> getAllCustomers(){
	List<Customer> l=customerserviceimp.getAllCustomers();
	return l;
}
@PutMapping("/assign/{pid}/{cid}")
public ResponseEntity<Customer> assignProductToCustomer(@PathVariable("pid") Long pid,@PathVariable("cid") Long cid){
	Customer c=customerserviceimp.assignProductToCustomer(pid, cid);
	return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
} 
		
		
		
	}

