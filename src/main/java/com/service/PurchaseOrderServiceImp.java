package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PurchaseOrderDAO;
import com.entity.Client;
import com.entity.PurchaseOrder;

/**
 * 
 * @author Tomasz Gomoradzki
 * Application Service layer for Purchase Order object interface implementation
 *
 */

@Service  // We add the annotation to service implementation
public class PurchaseOrderServiceImp implements PurchaseOrderService {
	
	// Injection of the Client DAO
	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;
		
	@Override
	@Transactional // Service layer define the beginning and end of transaction
	public List<PurchaseOrder> getPurchaseOrders() {
		// Delegating the get request to DAO
		return purchaseOrderDAO.getPurchaseOrders();
	}

	@Override
	@Transactional
	public List<Client> getClients() {
		// Delegating the get request to DAO
		return purchaseOrderDAO.getClients();
	}

	@Override
	@Transactional
	public List<Client> purchaseOrderAddSearchClient(String srchName) {
		return purchaseOrderDAO.purchaseOrderAddSearchClients(srchName);
	}
	@Override
	@Transactional
	public void savePurchaseOrder(PurchaseOrder thePorder) {
		purchaseOrderDAO.savePurchaseOrder(thePorder);		
	}

}
