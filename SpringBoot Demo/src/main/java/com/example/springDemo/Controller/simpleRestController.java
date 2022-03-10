package com.example.springDemo.Controller;

import com.example.springDemo.Model.HelloWorldClass;
//import com.example.springDemo.Model.Product;
import com.example.springDemo.Model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class simpleRestController {
    @GetMapping("/hello")
    public HelloWorldClass exampleMethod(@RequestParam(name="param1", defaultValue="World") String param1){
        return new HelloWorldClass("Rigen", "Kronaj");
    }

    @PostMapping("/hello")
    public HelloWorldClass exampleMethod2(@RequestBody HelloWorldClass body){
        return body;
        //return new HelloWorldClass("Rigen", "Kronaj");
    }

    @GetMapping("/nsi")
    public Student exampleStudent(@RequestParam(name="param1", defaultValue="test") String param1){
        return new Student("Rigen", "Shkoder", "0694673977");
    }

    @PostMapping("/nsi")
    public Student exampleStudent2(@RequestBody Student body){
        return body;
    }

    /*@GetMapping("/product")
    public Product exampleProduct(@RequestParam(name="param1", defaultValue="test") String param1){
        return new Product (1, "Laptop");
    }

    @PostMapping("/product")
    public Product exampleProduct2(@RequestBody Product body){
        return body;
    }*/
}
