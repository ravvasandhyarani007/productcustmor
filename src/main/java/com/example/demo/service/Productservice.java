package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Product;

public interface Productservice {
String saveProduct(Product p);
List<Product> getAllProducts();
String updateProduct(Product product,Long pid);
String deleteProduct(Long pid);
Optional<Product> getByProduct(Long pid);
}
