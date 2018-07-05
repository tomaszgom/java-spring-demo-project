package com.service;

import java.util.List;
import com.entity.Client;

public interface ClientService {

	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int clientId);

	public void deleteClient(int clientId);
}
