package com.service;

import java.util.List;

import com.entity.Client;
import com.entity.PurchaseOrder;

/**
 * 
 * @author Tomasz Gomoradzki
 * Application Service layer for Purchase Order object interface
 *
 */


public interface PurchaseOrderService {

	public List<PurchaseOrder> getPurchaseOrders();

	public List<Client> getClients();

	public List<Client> purchaseOrderAddSearchClient(String srchName);

	public void savePurchaseOrder(PurchaseOrder thePurchaseOrder);

}
