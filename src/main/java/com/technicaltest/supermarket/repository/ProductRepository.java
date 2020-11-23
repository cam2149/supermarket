package com.technicaltest.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.technicaltest.supermarket.entity.Product;

 
public interface ProductRepository extends JpaRepository<Product, Integer>{

    
    
}
