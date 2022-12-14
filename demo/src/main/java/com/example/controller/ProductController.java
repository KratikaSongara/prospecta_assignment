package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.ProductDTO;
import com.example.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/{category}")
	public ResponseEntity<List<ProductDTO>> getProductTitleAndDescription(@PathVariable("category") String category) {
		return new ResponseEntity<>(pservice.getTitleAndDescription(category), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(pservice.saveProduct(product), HttpStatus.ACCEPTED);
	}
}
