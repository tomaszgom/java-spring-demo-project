package com.dao;

import java.util.List;

import com.entity.Client;
import com.entity.PurchaseOrder;

/**
 * 
 * @author Tomasz Gomoradzki
 * Purchase Order Data Access Object interface
 * 
 */

public interface PurchaseOrderDAO {

	public List<PurchaseOrder> getPurchaseOrders();

	public List<Client> getClients();

	public List<Client> purchaseOrderAddSearchClients(String srchName);

	public void savePurchaseOrder(PurchaseOrder thePurchaseOrder);
	
}
