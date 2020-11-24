package com.technicaltest.supermarket.service;

import com.technicaltest.supermarket.mapper.ProductMapperImpl;
import com.technicaltest.supermarket.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    
    @Autowired
    private ProductMapperImpl repository;
     
    public List<Product> getProduts() {
        return repository.getProducts();
    }
     
    public Integer saveProduct(Product product) throws Exception {
        return repository.insertProduct(product);
    }
    
      
    public Product getProdutsbyId(Integer IdProducto) {
        return repository.findByIdProducto(IdProducto); 
    }
    
      
    public String delete(Integer id) {
        repository.deleteById(id);
        
        return "Producto eliminado !!" +id;
    }
    
    public Integer updateProduct(Product product) throws Exception{
        
        Product existingProduct = repository.findByIdProducto(product.getIdProducto());
        existingProduct.setCodigo(product.getCodigo());
        existingProduct.setNombre(product.getNombre());
        existingProduct.setValorUnidad(product.getValorUnidad());
        existingProduct.setStock(product.getStock());
        return repository.updateProduct(existingProduct);
        
        
        
        
    }
}