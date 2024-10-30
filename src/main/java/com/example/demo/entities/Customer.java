package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cid;
	@Column
	private String cname;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL ,fetch = FetchType.LAZY)
private List<Product> products;
	public Customer() {
		
	}
	public Customer(Long cid, String cname, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.products = products;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", products=" + products + "]";
	}
	
	 public void addProducts(Product products) {
	       
	            this.products.add(products);
	            products.add(this); // Ensures bidirectional consistency
	        }
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	
	
}
