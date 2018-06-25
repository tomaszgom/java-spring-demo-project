package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ClientDAO;
import com.entity.Client;

@Service  //we add the annotation to service implementation
public class ClientServiceImp implements ClientService {
	
	// injection of the Client DAO
	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional // service layer will define the beginning and end of trnsaction
	public List<Client> getClients() {
		//delegating the get request to DAO
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

}
