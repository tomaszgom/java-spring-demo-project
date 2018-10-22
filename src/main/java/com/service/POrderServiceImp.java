package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.POrderDAO;
import com.entity.Client;
import com.entity.POrder;

@Service  // We add the annotation to service implementation
public class POrderServiceImp implements POrderService {
	
	// Injection of the Client DAO
	@Autowired
	private POrderDAO pOrderDAO;
		
	@Override
	@Transactional // Service layer define the beginning and end of transaction
	public List<POrder> getPOrders() {
		// Delegating the get request to DAO
		return pOrderDAO.getPOrders();
	}

	@Override
	@Transactional
	public List<Client> getClients() {
		// Delegating the get request to DAO
		return pOrderDAO.getClients();
	}

	@Override
	@Transactional
	public List<Client> orderAddSearchClient(String srchName) {
		return pOrderDAO.orderAddSearchClients(srchName);
	}
	@Override
	@Transactional
	public void savePorder(POrder thePorder) {
		pOrderDAO.savePorder(thePorder);		
	}

}
