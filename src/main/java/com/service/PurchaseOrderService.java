package com.service;

import java.util.List;

import com.entity.Client;
import com.entity.PurchaseOrder;

public interface PurchaseOrderService {

	public List<PurchaseOrder> getPurchaseOrders();

	public List<Client> getClients();

	public List<Client> purchaseOrderAddSearchClient(String srchName);

	public void savePurchaseOrder(PurchaseOrder thePurchaseOrder);

}
