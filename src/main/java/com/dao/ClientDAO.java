package com.dao;

import java.util.List;
import com.entity.Client;

public interface ClientDAO {

	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int clientId);

	public void deleteClient(int clientId);

	public List<Client> searchClients(String srchName);
	
}
