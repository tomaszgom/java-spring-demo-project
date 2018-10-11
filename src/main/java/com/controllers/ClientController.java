package com.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.entity.POrder;
import com.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

		/*** Dismissed (left for reference) ***
		/*** inject the DAO Client - injecting DAO directly in case service layer is not used
		/*** Spring scans for the components that implements DAO interface, DAOImp will be injected */	
		//@Autowired
		//private ClientDAO clientDAO;
	 

	@Autowired		// injection of Client Service
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
		// System.out.println(" Client add. ID: "+theClient.getClient_id()+" Name: "+theClient.getLastName());
		
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
	//public String saveClient(@ModelAttribute("client") Client theClient) {
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
