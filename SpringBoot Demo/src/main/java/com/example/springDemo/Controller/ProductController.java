package com.example.springDemo.Controller;

import com.example.springDemo.Model.Product;
import com.example.springDemo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/(id)", method = RequestMethod.DELETE)
    public ResponseEntity<Object>deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product has been deleted successfully", HttpStatus.OK);
    }

    /*@RequestMapping(value = "/products/", method = RequestMethod.PUT)
    public ResponseEntity<Object>update(@PathVariable("id") Integer id, Product product){
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product has been updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public ResponseEntity<Object>create(@PathVariable("id") Integer id, Product product){
        productService.createProduct(product);
        return new ResponseEntity<>("Product has been added successfully", HttpStatus.OK);
    }*/
}
