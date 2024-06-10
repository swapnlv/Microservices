package com.smart;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.dto.ProductResponse;
import com.smart.repository.ProductRepo;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class ProductService1ApplicationTests {
	
	@Container
	static MySQLContainer<?> mySqlContainer = new MySQLContainer<>("mysql:8.0.29")
	        .withDatabaseName("shopping")
	        .withUsername("root")
	        .withPassword("Kittu@7905");
	
	
	@Autowired
	private MockMvc mockMVC;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Autowired
	private ProductRepo productRepo;
	
	
	@DynamicPropertySource
	    static void setProperties(DynamicPropertyRegistry registry) {
	        registry.add("spring.datasource.url", mySqlContainer::getJdbcUrl);
	        registry.add("spring.datasource.username", mySqlContainer::getUsername);
	        registry.add("spring.datasource.password", mySqlContainer::getPassword);
	    }
		
		

	 
	 

	@Test
	void shouldCreateProduct() throws Exception {
		 
		
		ProductResponse productRequest=getProductRequest();
		mockMVC.perform( (RequestBuilder) ((ResultActions) MockMvcRequestBuilders.post("/api/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(productRequest)))
                .andExpect(status().isCreated()));
		
		Assert.assertEquals(1, productRepo.findAll().size());
		
		
	}



	private ProductResponse getProductRequest() {
		return ProductResponse.builder().name("OnePlus 11R")
				.description("OpePlus 11R")
				.price(BigDecimal.valueOf(35000))
				.build();
}
	
}
