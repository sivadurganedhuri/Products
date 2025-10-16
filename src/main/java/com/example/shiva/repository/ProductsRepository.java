package com.example.shiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shiva.models.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
