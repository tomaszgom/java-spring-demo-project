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

import com.dao.POrderDAO;
import com.entity.Client;
import com.entity.POrder;
import com.service.ClientService;
import com.service.POrderService;

@Controller
@RequestMapping("/porder")
public class POrderController {
	
	
	
	@Autowired	// Injection of POrder Service
	private POrderService pOrderService;
	
	@Autowired	// Injection of Client Service
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listPOrders(Model theModel) {
		
			// get POrders from the Service
		List<POrder> thePOrders = pOrderService.getPOrders();
				
			//add the POrders to the model
		theModel.addAttribute("pOrders", thePOrders);
		
		return "pOrdersList";	
	}
	
	@GetMapping("/pOrderAddSelectClient")
	public String porderAddSelectClient(Model theModel) {
			
			// get clients from the Service
		List<Client> theClients = pOrderService.getClients();
				
			//add the clients to the model
		theModel.addAttribute("clients", theClients);
		
		return "pOrderAddSelectClient";		
	}
	
	
	@PostMapping("/pOrderAddSearchClient")
    public String orderAddSearchClient(@RequestParam("srchName") String srchName, Model theModel) {

        List<Client> theClients = pOrderService.orderAddSearchClient(srchName);
        theModel.addAttribute("clients", theClients);
        
        return "pOrderAddSelectClient";        
    }
	
	
	@PostMapping("/pOrderAddDetails")
    public String orderAddDetails(@RequestParam("clientId") String clientId, Model theModel) {
		
/*		if(clientId==null) {
			System.out.println("clientId to null");
		}*/
		System.out.println("T: orderAddDetails clicked; client: "+clientId);
//        List<Client> theClients = clientService.searchClients(srchName);
//        theModel.addAttribute("clients", theClients);
//        return "clientsList"; 
		
		int clientIdInt = Integer.parseInt(clientId);
		Client theClient = clientService.getClient(clientIdInt);
		
			// model attribute
		POrder theporder = new POrder();
		theporder.setClient(theClient);
		theModel.addAttribute("porder", theporder); // ("name", value)	
		
		System.out.println("Client");
		System.out.println("ID: "+theporder.getClient().getClient_id());
		System.out.println("Name: "+theporder.getClient().getLastName());
		System.out.println("City: "+theporder.getClient().getCity());	
		System.out.println("Order save");
		System.out.println("ID: "+theporder.getOrder_id());
		System.out.println("Product Name: "+theporder.getProductName());
		System.out.println("Order: "+theporder.getOrderValue());
        
		return "pOrderAddDetails";
    }
	
	@PostMapping("/porderSave")
	public String saveClient(@ModelAttribute("porder") POrder theporder) {
		
		System.out.println("Client");
		System.out.println("ID: "+theporder.getClient().getClient_id());
		System.out.println("Name: "+theporder.getClient().getLastName());
//		System.out.println("City: "+theporder.getClient().getCity());	
		System.out.println("Order save");
//		System.out.println("ID: "+theporder.getOrder_id());
		System.out.println("Product Name: "+theporder.getProductName());
		System.out.println("Order: "+theporder.getOrderValue());
				
			// save client with the use of Service
		pOrderService.savePorder(theporder);	
				
		return "pOrderAddDetails";
	}
	
}
