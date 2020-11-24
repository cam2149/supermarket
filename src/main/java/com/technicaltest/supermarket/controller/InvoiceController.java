/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technicaltest.supermarket.controller;

import com.technicaltest.supermarket.entity.Invoice;
import com.technicaltest.supermarket.mapper.InvoiceMapperImpl;
import com.technicaltest.supermarket.service.ProductService;
import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
    
    private ProductService service;
    private InvoiceMapperImpl serviceInvoice;

    @GetMapping("/invoice")
    public List<Invoice> findAllInvoices() {
        return serviceInvoice.getInvoices(); 
    }

    @GetMapping("/getInvoice/{id}")
    public ResponseEntity<Invoice> get(@PathVariable Integer id) {
        try {
            Invoice invoice = serviceInvoice.findByIdFactura(id);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addInvoice")
    public void addInvoice(@RequestBody Invoice invoice) throws Exception {
        serviceInvoice.insertInvoice(invoice);
    }

    @PutMapping("/updateInvoices/{id}")
    public ResponseEntity<?> update(@RequestBody Invoice invoice, @PathVariable Integer id) throws Exception {
        try {
            Invoice existInvoice = serviceInvoice.findByIdFactura(id);
            
            serviceInvoice.updateInvoice(existInvoice);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public void delete(@PathVariable Integer id) {
        serviceInvoice.deleteById(id);
    }
}
