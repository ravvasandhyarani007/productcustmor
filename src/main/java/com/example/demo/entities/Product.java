package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	@Column
	private String pname;
	@Column
	private int cost;
	@Column
	private String pquality;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cid")
	private Customer customer;
	public Product() {
		
	}
	public Product(Long pid, String pname, int cost, String pquality, Customer customer) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.pquality = pquality;
		this.customer = customer;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPquality() {
		return pquality;
	}
	public void setPquality(String pquality) {
		this.pquality = pquality;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", pquality=" + pquality + ", customer="
				+ customer + "]";
	}
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.customer.add(customer);
        customer.add(customer);
	}
	public void add(Customer customer2) {
		// TODO Auto-generated method stub
		
	}
	
		
}
