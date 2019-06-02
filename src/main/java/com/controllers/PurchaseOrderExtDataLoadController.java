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

import com.entity.Client;
import com.entity.PurchaseOrder;
import com.service.ClientService;
import com.service.PurchaseOrderService;

/**
 * 
 * @author Tomasz Gomoradzki
 * Purchase Order External Data Load Controller (dev in progress)
 * Class handling navigation and control for views associated with Purchase Orders loading interface,
 * module to load Orders from external data in form of a flat file json file
 *
 */

@Controller
@RequestMapping("/purchaseOrderExtDataLoad")
public class PurchaseOrderExtDataLoadController {
	
	
	@Autowired	// Injection of purchaseOrder Service
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired	// Injection of Client Service
	private ClientService clientService;
	
	@GetMapping("/inputLoad")
	public String showInputLoadPurchaseOrders(Model theModel) {
				
		return "InputLoadPurchaseOrders";	
	}
	
	@GetMapping("/loadSummary")
	public String showLoadSummary(Model theModel) {
				
		return "purchaseOrderLoadSummary";		
	}
	
	
	@GetMapping("/list")
	public String listPurchaseOrders(Model theModel) {
		
		// Get purchaseOrders from the Service		
		List<PurchaseOrder> thePurchaseOrders = purchaseOrderService.getPurchaseOrders();	
		
		// Add the purchase Orders to the model
		theModel.addAttribute("purchaseOrders", thePurchaseOrders);
		
		return "purchaseOrdersList";	
	}
		
	
	@PostMapping("/purchaseOrderSave")
	public String saveClient(@ModelAttribute("purchaseOrder") PurchaseOrder thePurchaseOrder) {
		
				
		// Save client with the use of Service
		purchaseOrderService.savePurchaseOrder(thePurchaseOrder);	
				
		// Return "purchaseOrdersList";
		return "redirect:/purchaseOrder/list";
	}
	
}
