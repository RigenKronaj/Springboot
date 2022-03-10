package com.example.springDemo.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.springDemo.Model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceImpl implements ProductService{

    private static Map<Integer, Product> productRepo = new HashMap<>();
    //for auto id generation
    private final AtomicLong counter = new AtomicLong();

    public ProductServiceImpl(){
        //loading data
        Product honey = new Product();
        honey.setId((int)counter.incrementAndGet());
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId((int)counter.incrementAndGet());
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Override
    public void createProduct(Product product) {
        //check if that product exists in the hashmap
        if(productRepo.containsKey(product.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product already exists.");
            
        //if the product does not exist, adds it to the hashmap
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        productRepo.remove(id); // removes the product from the hashmap
        product.setId(id); // to then replace it with an updated product
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        //lists all products
        return productRepo.values();
    }
    
}
