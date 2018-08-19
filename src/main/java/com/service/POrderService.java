package com.service;

import java.util.List;

import com.entity.Client;
import com.entity.POrder;

public interface POrderService {

	public List<POrder> getPOrders();

	public List<Client> getClients();

	public List<Client> orderAddSearchClient(String srchName);

	public void savePorder(POrder theporder);

}
