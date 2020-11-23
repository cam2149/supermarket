package com.technicaltest.supermarket.service;

import com.technicaltest.supermarket.repository.ProductRepository;
import com.technicaltest.supermarket.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;
     
    public List<Product> getProduts() {
        return repository.findAll();
    }
     
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
     
    public Product getProdutsbyId(Integer id) {
        return repository.findById(id).get(); 
    }
    
      
    public String delete(Integer id) {
        repository.deleteById(id);
        
        return "Producto eliminado !!" +id;
    }
    
    public Product updateProduct(Product product){
        
        Product existingProduct = repository.findById(product.getIdProducto()).orElse(null);
        existingProduct.setCodigo(product.getCodigo());
        existingProduct.setNombre(product.getNombre());
        existingProduct.setValorUnidad(product.getValorUnidad());
        existingProduct.setStock(product.getStock());
        return repository.save(existingProduct);
        
        
        
        
    }
}