package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;
import com.zensar.services.ProductService;
/**
 * @author Arib aka FREAKSTER
 * @creation_date 12th Oct 2019 15:44
 * @modification_date 12th Oct 2019 15:44
 * @version 1.0
 * @copyright Zensar Tech
 * @description This is a RESTful Webservice.
 */
@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		
		return productService.findAllProducts();
	}
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id")int productId) {
		return productService.findById(productId);
	}
	@PostMapping("/products/add")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	return "New Product added "+product.getProductId()+" is added!";
	}
	@PostMapping("/products/addproduct")
	public String addProduct(@RequestParam("id") int productId,@RequestParam("name")String name,@RequestParam("brand")String brand,@RequestParam("price")float price) {
		Product product= new Product(productId,name,brand,price);
		productService.addProduct(product);
		return "New Product added "+product.getProductId()+" is added!";
	}
	@PutMapping("/products/update")
	public String update(@RequestBody Product product) {
		if (productService.findById(product.getProductId())!=null){
		productService.updateProduct(product);
		return "Product is updated Successfully";}
		else return "Sorry! Product not found";
	}
	@DeleteMapping("/products/delete")
	public String delete(@RequestBody Product product) {
		if (productService.findById(product.getProductId())!=null){
		productService.removeProduct(product);
		return "Product is deleted Successfully";}
		else return "Sorry! Product not found";
	}
}
