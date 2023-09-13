package com.example.kitchenstory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitchenstory.model.Product;
import com.example.kitchenstory.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Product")

public class ProductController {
	@Autowired
	ProductRepository PR;
	
	@GetMapping("all")
	public List<Product> getAll()
	{
		List<Product> a= (List<Product>) PR.findAll();
		return a;
	}
	
	
	@PostMapping("add")
	public Product addBook(@RequestBody Product Product)
	{
		return PR.save(Product);
	}
	
	// get particular student by their ID
		@GetMapping("user/{id}")
		public Optional<Product> getUserById(@PathVariable int id)
		{
			return PR.findById(id);
		}
		
		// update existing student 
		@PutMapping("update/{id}")
		public Product updateUser(@RequestBody Product Product)
		{
			return PR.save(Product);
		}
		
		// delete particular student from database
		@DeleteMapping("delete/{id}")
		public void deleteUser(@PathVariable int id)
		{
			PR.deleteById(id);
		}
}
