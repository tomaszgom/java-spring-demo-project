package com.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ClientDAO;
import com.entity.Client;
import com.entity.PurchaseOrder;

@Service  // Adding the annotation to service implementation
public class ClientServiceImp implements ClientService {
	
	// Injection of the Client DAO
	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional // Service layer defines the beginning and end of transaction
	public List<Client> getClients() {
		// Delegating the get request to DAO
		return clientDAO.getClients();
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		clientDAO.saveClient(theClient);		
	}

	@Override
	@Transactional
	public Client getClient(int clientId) {
		return clientDAO.getClient(clientId);
	}

	@Override
	@Transactional
	public void deleteClient(int clientId) {
		clientDAO.deleteClient(clientId);	
	}

	@Override
	@Transactional
	public List<Client> searchClients(String srchName) {
		return clientDAO.searchClients(srchName);
	}
	@Override
	@Transactional
	public HashMap<String, Double> getStats() {
		return clientDAO.getStats();
	}

	@Override
	@Transactional
	public List<PurchaseOrder> viewClientPurchaseOrders(Client theClient) {
		return clientDAO.viewClientPurchaseOrders(theClient);
	}


}
