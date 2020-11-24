/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.controller;

import com.technicaltest.supermarket.entity.Product;
import com.technicaltest.supermarket.service.ProductService;
import java.util.*;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService service;

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProduts(); 
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.getProdutsbyId(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) throws Exception {
        service.saveProduct(product);
    }

    @PutMapping("/updateProducts/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) throws Exception {
        try {
            Product existProduct = service.getProdutsbyId(id);
            
            service.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
