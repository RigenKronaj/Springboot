package com.example.springDemo.Service;

import java.util.Collection;

import com.example.springDemo.Model.Product;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(Integer id, Product product);
    public abstract void deleteProduct(Integer id);
    public abstract Collection<Product> getProducts();
}
