package com.example.shiva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shiva.models.Products;
import com.example.shiva.service.ProductsService;

@RestController
@RequestMapping("/api/users/products")
public class ProductsController {
	@Autowired
	private ProductsService service;
	
	@PostMapping("/newproduct")
	public Products newProduct(@RequestBody Products p) {
		return service.addProduct(p);
	}
	
	@GetMapping
	public List<Products> allProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Optional<Products> singleProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	@PutMapping("/changeproduct/{id}")
	public Products changeProduct(@RequestBody Products p,@PathVariable int id) {
		return service.updateProduct(p, id);
	}
	
	@DeleteMapping("/removeproduct/{id}")
	public String removeProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
