package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.ProductDAO;
import com.entity.Client;
import com.entity.Product;
import com.service.ClientService;
import com.service.ProductService;

/**
 * 
 * @author Tomasz Gomoradzki
 * Product Controller class handling navigation and control for views
 * associated with Purchase Order application entity
 *
 */

@Controller
@RequestMapping("/Product")
public class ProductController {
	
	
	@Autowired	// Injection of Product Service
	private ProductService ProductService;
	
	@Autowired	// Injection of Client Service
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		// Get Products from the Service		
		List<Product> theProducts = ProductService.getProducts();	
		
		// Add the purchase Orders to the model
		theModel.addAttribute("Products", theProducts);
		
		return "ProductsList";	
	}
	
			
	
	@PostMapping("/ProductAddForm")
    public String ProductAddForm( Model theModel) {
				
		// Model attribute
		Product theProduct = new Product();

		theModel.addAttribute("Product", theProduct); // ("name", value)	
		        
		return "ProductAddForm";
    }
	
	@PostMapping("/ProductSave")
	public String saveClient(@ModelAttribute("Product") Product theProduct) {
						
		// Save client with the use of Service
		ProductService.saveProduct(theProduct);	
				
		// Return "ProductsList";
		return "redirect:/Product/list";
	}
	
}
