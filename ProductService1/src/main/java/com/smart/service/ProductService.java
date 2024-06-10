package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dto.ProductRequest;
import com.smart.dto.ProductResponse;
import com.smart.model.Product;
import com.smart.repository.ProductRepo;

@Service
public class ProductService {
	
	
	@Autowired
	ProductRepo prodRepo;
	
	public void createProduct(ProductRequest prodReq) {
		Product prod=Product.builder().
				name(prodReq.getName()).
				description(prodReq.getDescription()).
				price(prodReq.getPrice()).build();
		
		
		prodRepo.save(prod);
	}
	public List<ProductResponse> listProducts(){
		
		List<Product> products= prodRepo.findAll();
		
		return products.stream().map(product-> maptoResponse(product)).toList();
		
	}
	private ProductResponse maptoResponse(Product product) {
		// TODO Auto-generated method stub
		return ProductResponse.builder().
				id(product.getId()).
				name(product.getName()).
				description(product.getDescription()).
				price(product.getPrice()).
				build();
	}
	public ProductResponse getByID(int id) {
		// TODO Auto-generated method stub
		
		Product product=prodRepo.getById(id);
		
		
		return maptoResponse(product);
	}
}
