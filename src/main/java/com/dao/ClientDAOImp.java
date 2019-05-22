package com.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Client;
import com.entity.PurchaseOrder;

/**
 * 
 * @author Tomasz Gomoradzki
 * Client Data Access Object interface Implementation
 * (Some Spring notes at the end)
 *
 */

@Repository
public class ClientDAOImp implements ClientDAO {

	// Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
		
	@Override // In simpler version, without Service layer @Transactional could be annotated here
	public List<Client> getClients() {
		
		// Get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
		// Create a query, execute and get result list
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);	
		List<Client> clients = theQuery.getResultList();
		//  Return the results
		return clients;
	}

	@Override
	public void saveClient(Client theClient) {	
		// Get Hibernate session and save client
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(theClient.getClient_id() == 0) {
			//  Hibernate checks if this is new object by checking if ID is empty, if so it will insert else it will update
			//  currentSession.saveOrUpdate(theClient);
			currentSession.save(theClient);	
		}else{
			// saved data as new record
			currentSession.update(theClient);
		}
	}


	@Override
	public Client getClient(int clientId) {
		// Get current session and read from database
		Session currSession = sessionFactory.getCurrentSession();
		Client theClient = currSession.get(Client.class, clientId);
		return theClient;
	}

	@Override
	public void deleteClient(int clientId) {
		// Get session, create query to delete object and exec
		Session currSession = sessionFactory.getCurrentSession();
		
		// Query theQuery = currSession.createQuery("delete from Client where client_id=:cliID");
		// theQuery.setParameter("cliID", clientId);
		// theQuery.executeUpdate();
		
		Query theQuery = currSession.createQuery("from Client where client_id=:cliID");
		theQuery.setParameter("cliID", clientId);
		Client cli= (Client)theQuery.list().get(0);
		currSession.delete(cli);
	}

	@Override
	public List<Client> searchClients(String srchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
        // If name is not empty
        if (srchName != null && srchName.trim().length() > 0) {
            // Search by firstName or lastName
            theQuery =currentSession.createQuery("from Client where lower(firstName) like :theName or lower(lastName) like :theName", Client.class);
            theQuery.setParameter("theName", "%" + srchName.toLowerCase() + "%");          
        }else {
            theQuery =currentSession.createQuery("from Client", Client.class);            
        }
        
        List<Client> clientsResult = theQuery.getResultList();       
        return clientsResult;
	}
	
	
	/** Querying Clients and Purchase orders stats **/
	
	@Override
	public HashMap<String, Double> getStats() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query totalClients = null;
		Query totalPurchaseOrders = null;
		Query maxClientsPoints = null;
		Query avgPurchaseOrderValue = null;	
	    HashMap<String, Double> stats = new HashMap();
	      
	    totalClients = currentSession.createQuery("select count(*) from Client");        
	    totalPurchaseOrders = currentSession.createQuery("select count(*) from PurchaseOrder");
	    maxClientsPoints = currentSession.createQuery("select max(points) from Client");
	    avgPurchaseOrderValue = currentSession.createQuery("select avg(orderValue) from PurchaseOrder");
	    
	    
        Double totCli = ((Long) (totalClients.uniqueResult())).doubleValue();
        Double totOrd = ((Long) (totalPurchaseOrders.uniqueResult())).doubleValue();
        Double maxCliPo = ((Integer) (maxClientsPoints.uniqueResult())).doubleValue();
        Double avgOrdVal = ((Double) (avgPurchaseOrderValue.uniqueResult())).doubleValue();
       
        
        stats.put("totalClients", totCli); 
        stats.put("totalPurchaseOrders", totOrd);
        stats.put("maxClientsPoints", maxCliPo);
        stats.put("avgOrderValue", avgOrdVal);
             
        return stats;
	}

	@Override
	public List<PurchaseOrder> viewClientPurchaseOrders(Client theClient) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
            theQuery =currentSession.createQuery("from PurchaseOrder where client=:cliID", PurchaseOrder.class);
        	theQuery.setParameter("cliID", theClient);
                           
        List<PurchaseOrder> purchaseOrdersResult = theQuery.getResultList();    
        // List<PurchaseOrder> ordersResult = theClient.getPurchaseOrders();
         return purchaseOrdersResult;
         // return theClient.getPurchaseOrders();
	}

}


/* Dev Notes, Please ignore
 * 
 * Annotations for DAO Data Access Object
 * @Component - component scanning for Java beans
 * @Controller - Spring MVC special class that will handle all MVC work, spring will handle auto components scannig
 * and load it automatically
 * 
 * @Repoitory - all DAO implementation classes, this will be available for component scanning
 * Spring will automatically register the DAO implementation thanks to component scanning
 * Spring will also provide translation of any JDBC related exceptions
 * 
 * @Transactional on given method thanks to which we dont have to manually start and stop session
 * */

/*
 * 		// Code that we would normally use to start and end session, transaction
 * 		// start transaction
 * 	session.beginTransaction();
 * 		//Do something
 * 
 * 		// commit transaction
 * //session.getTransaction().commit();
 * 
 * */