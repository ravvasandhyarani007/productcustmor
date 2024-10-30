package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repository.Productrepository;
@Service
public class Productserviceimp implements Productservice{
	@Autowired
private Productrepository productrepository;
	
	public Productserviceimp(Productrepository productrepository) {
		super();
		this.productrepository = productrepository;
	}

	@Override
	public String saveProduct(Product p) {
		// TODO Auto-generated method stub
		productrepository.save(p);
		return "product inserted";
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> li=productrepository.findAll();
		return li;
	}

	@Override
	public String updateProduct(Product product, Long pid) {
		// TODO Auto-generated method stub
		Product pdt=productrepository.findById(pid).get();
		pdt.setPname(product.getPname());
		pdt.setPquality(product.getPquality());
		pdt.setCost(product.getCost());
		productrepository.save(pdt);
		return "product updated";
	}

	@Override
	public String deleteProduct(Long pid) {
		// TODO Auto-generated method stub
		productrepository.deleteById(pid);
		return "product deleted";
	}

	@Override
	public Optional<Product> getByProduct(Long pid) {
		// TODO Auto-generated method stub
		      return  productrepository.findById(pid);

}
}
