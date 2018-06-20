package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ClientDAO;
import com.entity.Client;
import com.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	//* inject the DAO Client, this section - injecting DAO directly,
	//* would be uncommented if we would not use service layer
	//@Autowired
	//private ClientDAO clientDAO;//Spring will scan for the components that implements DAO interface, do DAOImp will be injected
	
	//* injection of Client Service
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list") 	//Get handles only GET requests, @RequestMapping handles all
	public String listClients(Model theModel) {
		
		
		//* get clients from the dao - would be used if Service was not in place
		//List<Client> theClients = clientDAO.getClients();
		
		// get clients from the Service
		List<Client> theClients = clientService.getClients();
				
		//add the customers to the model
		theModel.addAttribute("clients", theClients);
		
		return "list-clients";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		// model attribute
		Client theClient = new Client();
		
		theModel.addAttribute("client", theClient); // ("name", value)
		
		return "client-form";
	}
	
	
	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client theClient) {
		
		// save client with the use of Service
		clientService.saveClient(theClient);
		
		return "redirect:/client/list";
	}
	

	
	
}
