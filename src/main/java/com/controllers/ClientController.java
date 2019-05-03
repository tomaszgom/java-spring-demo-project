package com.controllers;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.ClientDAO;
import com.entity.Client;
import com.entity.PurchaseOrder;
import com.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

		/*** Dismissed (left for reference) ***
		/*** inject the DAO Client - injecting DAO directly in case service layer is not used
		/*** Spring scans for the components that implements DAO interface, DAOImp will be injected */	
		//@Autowired
		//private ClientDAO clientDAO;
	 

	@Autowired		// Injection of Client Service
	private ClientService clientService;
	
	@GetMapping("/list") 	// Get handles only GET requests, @RequestMapping handles all
	public String listClients(Model theModel) {
		
		// Get clients from the dao - option with no Service layer	
		//List<Client> theClients = clientDAO.getClients();
		
		// Get clients from the Service	
		List<Client> theClients = clientService.getClients();
		
		// Sort by ID, by default using custom comparator
		Collections.sort(theClients, new ClientComparatorById());
		
		//	Add the clients to the model
		theModel.addAttribute("clients", theClients);
		
		return "clientsList";	
	}
	
	@GetMapping("/list-sort") 
	public String listClientsSorted(@RequestParam("sortBy") String sortBy, Model theModel) {
		
		// Get clients from the Service	
		List<Client> theClients = clientService.getClients();
		
		// Sort by based on parameter
		switch(sortBy) {
		case "id": Collections.sort(theClients, new ClientComparatorById()); break;
		case "firstName": Collections.sort(theClients, new ClientComparatorByFirstName()); break;
		case "lastName": Collections.sort(theClients, new ClientComparatorByLastName()); break;
		case "city": Collections.sort(theClients, new ClientComparatorByCity()); break;
		case "points": Collections.sort(theClients, new ClientComparatorByPoints()); break;
		case "loginDate": Collections.sort(theClients, new ClientComparatorByLoginDate()); break;
		}
		
		//	Add the clients to the model
		theModel.addAttribute("clients", theClients);
		
		return "clientsList";	
	}
	
	// Comparators 
	
	public class ClientComparatorById implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
			return Integer.compare(o1.getClient_id(), o2.getClient_id());
		}	
	}	
	public class ClientComparatorByFirstName implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
			 return o1.getFirstName().compareTo(o2.getFirstName());
		}	
	}
	public class ClientComparatorByLastName implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
			 return o1.getLastName().compareTo(o2.getLastName());
		}	
	}
	public class ClientComparatorByCity implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
			 return o1.getCity().compareTo(o2.getCity());
		}	
	}
	public class ClientComparatorByPoints implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
			return Integer.compare(o1.getPoints(), o2.getPoints());
		}	
	}
	public class ClientComparatorByLoginDate implements Comparator<Client>{	
		@Override
		public int compare(Client o1, Client o2) {
		     
			Date date = o1.getLastLoginDate();
		    Date date2 = o2.getLastLoginDate();
		      
		      if(date==null) {
		    	  date = new Date(9999, 1, 9);
		      }
		      if(date2==null) {
		    	  date2 = new Date(9999, 1, 9);
		      }
		      
			return date.compareTo(date2);
		}	
	}
	
	
	@GetMapping("/formAddClient")
	public String formAddClient(Model theModel){
		
		// Model attribute
		Client theClient = new Client();
		
		theModel.addAttribute("client", theClient); // ("name", value)
		
		return "clientForm";
	}
	
	@GetMapping("/formEditClient")
	public String formEditClient(@RequestParam("clientId") int clientId, Model theModel) {
		
		// Get client and add to model for the form	
		Client theClient = clientService.getClient(clientId);
		theModel.addAttribute("client", theClient);
		
		return "clientForm";
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {
			System.out.println("Form errors: "+theBindingResult.getAllErrors().toString());
			return "clientForm";
		}else {
			System.out.println("No Form Errors");
			
			// Save client with the use of Service
			clientService.saveClient(theClient);	
			
			return "redirect:/client/list";
		}
			
	}
			
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Client Form String Trim
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		// Client Form date format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(true);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}
		
	
	@PostMapping("/search")
	public String searchClient(@RequestParam("srchName") String srchName, Model theModel) {
		
		List<Client> theClients = clientService.searchClients(srchName);
		theModel.addAttribute("clients", theClients);
		
		return "clientsList";      
	}
	
	@GetMapping("/purchaseOrders")
    public String viewClientPurchaseOrders(@RequestParam("clientId") int clientId, Model theModel) {

		Client theClient = clientService.getClient(clientId);
		
        List<PurchaseOrder> thePurchaseOrders = clientService.viewClientPurchaseOrders(theClient);
        theModel.addAttribute("purchaseOrders", thePurchaseOrders);
        
        return "purchaseOrdersList";
    }
	
	@GetMapping("/delete")
	public String deleteClient(@RequestParam("clientId") int clientId) {
		
		clientService.deleteClient(clientId);
		
		return "redirect:/client/list";
	}
}
