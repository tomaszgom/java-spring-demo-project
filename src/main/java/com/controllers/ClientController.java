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

import com.dao.ClientDAO;
import com.entity.Client;
import com.entity.POrder;
import com.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
		// inject the DAO Client - injecting DAO directly in case service layer is not used
	
	//@Autowired
	//private ClientDAO clientDAO;//Spring will scan for the components that implements DAO interface, do DAOImp will be injected
	
		// injection of Client Service
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list") 	//Get handles only GET requests, @RequestMapping handles all
	public String listClients(Model theModel) {
		
			// Get clients from the dao - option with no Service layer	
		//List<Client> theClients = clientDAO.getClients();
		
			// Get clients from the Service
		List<Client> theClients = clientService.getClients();
				
			//	Add the clients to the model
		theModel.addAttribute("clients", theClients);
		
		return "clientsList";
		
	}
	
	@GetMapping("/formAddClient")
	public String formAddClient(Model theModel){
		
			// Model attribute
		Client theClient = new Client();
//		System.out.println(" Client add form opened");
//		System.out.println("ID: "+theClient.getClient_id());
//		System.out.println("Name: "+theClient.getLastName());
		
		theModel.addAttribute("client", theClient); // ("name", value)
		return "clientForm";
	}
	
	
	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client theClient) {
		
//		System.out.println("Client save");
//		System.out.println("ID: "+theClient.getClient_id());
//		System.out.println("Name: "+theClient.getLastName());
//		System.out.println("City: "+theClient.getCity());
				
			// save client with the use of Service
		clientService.saveClient(theClient);	
		return "redirect:/client/list";
	}
		
	@PostMapping("/search")
    public String searchClient(@RequestParam("srchName") String srchName, Model theModel) {

        List<Client> theClients = clientService.searchClients(srchName);
        theModel.addAttribute("clients", theClients);
        return "clientsList";        
    }
	
	@GetMapping("/formEditClient")
	public String formEditClient(@RequestParam("clientId") int clientId, Model theModel) {
		
			//get client and add to model for the form
		Client theClient = clientService.getClient(clientId);
		theModel.addAttribute("client", theClient);
		
		return "clientForm";
	}
	
	@GetMapping("/pOrders")
    public String viewClientPOrders(@RequestParam("clientId") int clientId, Model theModel) {

		Client theClient = clientService.getClient(clientId);
        List<POrder> theOrders = clientService.viewClientPOrders(theClient);
        theModel.addAttribute("pOrders", theOrders);
        return "pOrdersList";
    
    }
	
	@GetMapping("/delete")
	public String deleteClient(@RequestParam("clientId") int clientId) {
		
		clientService.deleteClient(clientId);
		return "redirect:/client/list";
	}
}
