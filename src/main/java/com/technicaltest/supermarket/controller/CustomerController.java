/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.controller;

import com.technicaltest.supermarket.entity.Customer;
import com.technicaltest.supermarket.mapper.CustomerMapperImpl;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
 
    private CustomerMapperImpl service;

    @GetMapping("/customers")
    public List<Customer> findAllProducts() {
        return service.getCustomers(); 
    }

    @GetMapping("/customers/{id}")
    public Customer delete(@PathVariable Integer id) {
        return service.findByIdCliente(id);
    }
}
