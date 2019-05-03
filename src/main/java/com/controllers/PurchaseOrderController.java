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

import com.dao.PurchaseOrderDAO;
import com.entity.Client;
import com.entity.PurchaseOrder;
import com.service.ClientService;
import com.service.PurchaseOrderService;

@Controller
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {
	
	
	@Autowired	// Injection of purchaseOrder Service
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired	// Injection of Client Service
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listPurchaseOrders(Model theModel) {
		
		// Get purchaseOrders from the Service		
		List<PurchaseOrder> thePurchaseOrders = purchaseOrderService.getPurchaseOrders();	
		
		// Add the purchase Orders to the model
		theModel.addAttribute("purchaseOrders", thePurchaseOrders);
		
		return "purchaseOrdersList";	
	}
	
	@GetMapping("/purchaseOrderAddSelectClient")
	public String purchaseOrderAddSelectClient(Model theModel) {
			
		// Get clients from the Service
		List<Client> theClients = purchaseOrderService.getClients();
				
		// Add the clients to the model	
		theModel.addAttribute("clients", theClients);
		
		return "purchaseOrderAddSelectClient";		
	}
	
	
	@PostMapping("/purchaseOrderAddSearchClient")
    public String purchaseOrderAddSearchClient(@RequestParam("srchName") String srchName, Model theModel) {

        List<Client> theClients = purchaseOrderService.purchaseOrderAddSearchClient(srchName);
        theModel.addAttribute("clients", theClients);
        
        return "purchaseOrderAddSelectClient";        
    }
	
	
	@PostMapping("/purchaseOrderAddForm")
    public String purchaseOrderAddForm(@RequestParam("clientId") String clientId, Model theModel) {
		
//		  System.out.println("Contr Msg: purchaseOrderAddDetails clicked; client: "+clientId);
//        List<Client> theClients = clientService.searchClients(srchName);
//        theModel.addAttribute("clients", theClients);
//        return "clientsList"; 
		
		int clientIdInt = Integer.parseInt(clientId);
		Client theClient = clientService.getClient(clientIdInt);
		
		// Model attribute
		PurchaseOrder thePurchaseOrder = new PurchaseOrder();
		thePurchaseOrder.setClient(theClient);
		theModel.addAttribute("purchaseOrder", thePurchaseOrder); // ("name", value)	
		
/*		System.out.println("Contr Msg: Client");
		System.out.println("Contr Msg: ID: "+thePurchaseOrder.getClient().getClient_id());
		System.out.println("Contr Msg: Name: "+thePurchaseOrder.getClient().getLastName());
		System.out.println("Contr Msg: City: "+thePurchaseOrder.getClient().getCity());	
		System.out.println("Contr Msg: Purchase Order save");
		System.out.println("Contr Msg: ID: "+thePurchaseOrder.getPurchaseOrder_id());
		System.out.println("Contr Msg: Product Name: "+thePurchaseOrder.getProductName());
		System.out.println("Contr Msg: Purchase Order: "+thePurchaseOrder.getPurchaseOrderValue());
*/
        
		return "purchaseOrderAddForm";
    }
	
	@PostMapping("/purchaseOrderSave")
	public String saveClient(@ModelAttribute("purchaseOrder") PurchaseOrder thePurchaseOrder) {
		
/*		System.out.println("Contr Msg: Client");
		System.out.println("Contr Msg: ID: "+thePurchaseOrder.getClient().getClient_id());
		System.out.println("Contr Msg: Name: "+thePurchaseOrder.getClient().getLastName());
//		System.out.println("Contr Msg: City: "+thePurchaseOrder.getClient().getCity());	
		System.out.println("Contr Msg: Order save");
//		System.out.println("Contr Msg: ID: "+thePurchaseOrder.getOrder_id());
		System.out.println("Contr Msg: Product Name: "+thePurchaseOrder.getProductName());
		System.out.println("Contr Msg: Order: "+thePurchaseOrder.getOrderValue());
*/
				
		// Save client with the use of Service
		purchaseOrderService.savePurchaseOrder(thePurchaseOrder);	
				
		// Return "purchaseOrdersList";
		return "redirect:/purchaseOrder/list";
	}
	
}
