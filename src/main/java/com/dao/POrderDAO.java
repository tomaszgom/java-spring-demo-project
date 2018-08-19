package com.dao;

import java.util.List;

import com.entity.Client;
import com.entity.POrder;

public interface POrderDAO {

	public List<POrder> getPOrders();

	public List<Client> getClients();

	public List<Client> orderAddSearchClients(String srchName);

	public void savePorder(POrder thePorder);
	
}
