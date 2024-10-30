package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.service.Productserviceimp;
@RestController
@RequestMapping("/api/product")
public class Productcontroller {
	@Autowired
private Productserviceimp productserviceimp;

public Productcontroller(Productserviceimp productserviceimp) {
	super();
	this.productserviceimp = productserviceimp;
}
@PostMapping("/addproduct")
public ResponseEntity<String> saveProduct(@RequestBody Product p){
	productserviceimp.saveProduct(p);
	return new ResponseEntity<> ("product inserted",HttpStatus.CREATED);
}
@GetMapping("/details")
public List<Product> getAllProducts(){
	List<Product> li=productserviceimp.getAllProducts();
	return li;
}
@PutMapping("/updateproduct/{pid}")
public ResponseEntity<String> updateProduct(@PathVariable("pid") Long pid,@RequestBody Product product){
	productserviceimp.updateProduct(product, pid);
	return new ResponseEntity<>("product updated",HttpStatus.OK);
}
@DeleteMapping("/deleteproduct/{pid}")
public ResponseEntity<String> deleteProduct(@PathVariable("pid") Long pid){
	productserviceimp.deleteProduct(pid);
	return new ResponseEntity<>("product deleted",HttpStatus.ACCEPTED);
}

	 @GetMapping("/{pid}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long pid) {
	        // Call the service to get the product
	        Optional<Product> product = productserviceimp.getByProduct(pid);

	        // Check if the product is present
	        if (product.isPresent()) {
	            return ResponseEntity.ok(product.get());
	        } else {
	            // Return 404 NOT FOUND if product is not present
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

}

