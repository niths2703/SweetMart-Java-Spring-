package com.sweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.model.Product;
import com.sweetmart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService pServ;
	
	@PostMapping("/add/{key}")
	public ResponseEntity<Product> addProduct(@RequestBody Product p,@PathVariable String key  ){
		
		Product pro=pServ.addProduct(key, p);
		
		return new ResponseEntity<>(pro,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{key}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product p,@PathVariable String key ){
Product pro=pServ.updateProduct(key, p);
		
		return new ResponseEntity<>(pro,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{key}/{id}")
  public ResponseEntity<Product> deleteProductById(@PathVariable String key, @PathVariable("id") Integer id){
Product pro=pServ.deleteProductById(key, id);
		
		return new ResponseEntity<>(pro,HttpStatus.ACCEPTED);
   }
	
}
