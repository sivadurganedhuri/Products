package com.example.shiva.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shiva.models.Products;
import com.example.shiva.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository repo;
	
	public Products addProduct(Products p) {
		return repo.save(p);
	}
	
	public java.util.List<Products> getAllProducts(){
		return repo.findAll();
	}
	
	public Optional<Products> getProduct(int id) {
		return repo.findById(id);
	}
	public Products updateProduct(Products p, int id) {
		Products p1=repo.findById(id).orElse(null);
		p1.setProductName(p.getProductName());
		p1.setProductBrand(p.getProductBrand());
		p1.setPrice(p.getPrice());
		p1.setDescription(p.getDescription());
		p1.setCategory(p.getCategory());
		p1.setAvailability(p.getAvailability());
		return repo.save(p1);
		
		
	}
	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "Successfully Deleted";
	}
}
