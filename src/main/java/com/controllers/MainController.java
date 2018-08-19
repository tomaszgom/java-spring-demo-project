package com.controllers;


import java.util.HashMap;
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
import com.service.ClientService;

@Controller
@RequestMapping("/app")
public class MainController {
	

		// injection of Client Service
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/welcome")
	public String welcomeView (Model theModel) {
		return "welcome";
	}
	
	@GetMapping("/dashboard")
	public String dashboardView (Model theModel) {
		
		HashMap<String, Double> stats = clientService.getStats();
		HashMap<String, String> statsPrint = new HashMap<String, String>();
		
		for (HashMap.Entry<String, Double> entry : stats.entrySet()) {	
			String stat = String.format("%.1f", entry.getValue()); 
		
			statsPrint.put(entry.getKey(), stat);			
		}
				
        theModel.addAttribute("stats", statsPrint);
              
//        System.out.println("Total Clients: ");
//        System.out.println(stats.get("totalClients"));
        
		return "dashboard";
	}
	
	@GetMapping("/goodbye")
	public String goodyeView (Model theModel) {
		return "goodbye";
	}
	
}

