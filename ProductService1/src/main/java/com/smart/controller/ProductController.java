package com.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.ProductRequest;
import com.smart.dto.ProductResponse;
import com.smart.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest prodReq) {
        productService.createProduct(prodReq);
        
    }
    
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> listProducts(){

    	
    	return productService.listProducts();
    }
    
    @GetMapping("/{id}")
    public ProductResponse getByID(@PathVariable int id) {
        return productService.getByID(id);
    }
    
}
