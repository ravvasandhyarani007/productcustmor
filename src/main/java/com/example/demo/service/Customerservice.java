package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Customer;

public interface Customerservice {
String saveCustomer(Customer c);
List<Customer> getAllCustomers();
Customer assignProductToCustomer(Long pid,Long cid);
}
