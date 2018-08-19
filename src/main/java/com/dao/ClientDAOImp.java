package com.dao;
//******************
// NOTES BELOW

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
import com.entity.POrder;

@Repository
public class ClientDAOImp implements ClientDAO {

		//  Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
		
	@Override //in simpler version, without Service layer @Transactional could be annotated here
	public List<Client> getClients() {
		
			//  Get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
			//  create a query, execute and get result list
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);	
		List<Client> clients = theQuery.getResultList();
			//  return the results
		return clients;
	}

	@Override
	public void saveClient(Client theClient) {	
			// get Hibernate session and save client
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
			//get current session and read from database
		Session currSession = sessionFactory.getCurrentSession();
		Client theClient = currSession.get(Client.class, clientId);
		return theClient;
	}

	@Override
	public void deleteClient(int clientId) {
			//get session, create query to delete object and exec
		Session currSession = sessionFactory.getCurrentSession();
		Query theQuery = currSession.createQuery("delete from Client where client_id=:cliID");
		theQuery.setParameter("cliID", clientId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Client> searchClients(String srchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
        	// if name is not empty
        if (srchName != null && srchName.trim().length() > 0) {
            	// search by firstName or lastName
            theQuery =currentSession.createQuery("from Client where lower(firstName) like :theName or lower(lastName) like :theName", Client.class);
            theQuery.setParameter("theName", "%" + srchName.toLowerCase() + "%");          
        }else {
            theQuery =currentSession.createQuery("from Client", Client.class);            
        }
        
        List<Client> clientsResult = theQuery.getResultList();       
        return clientsResult;
	}
	@Override
	public HashMap<String, Double> getStats() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query totalClients = null;
		Query totalOrders = null;
		Query maxClientsPoints = null;
		Query avgOrderValue = null;	
	    HashMap<String, Double> stats = new HashMap();
	      
	    totalClients = currentSession.createQuery("select count(*) from Client");        
	    totalOrders = currentSession.createQuery("select count(*) from POrder");
	    maxClientsPoints = currentSession.createQuery("select max(points) from Client");
	    avgOrderValue = currentSession.createQuery("select avg(orderValue) from POrder");
            
        Double totCli = ((Long) (totalClients.uniqueResult())).doubleValue();
        Double totOrd = ((Long) (totalOrders.uniqueResult())).doubleValue();
        Double maxCliPo = ((Integer) (maxClientsPoints.uniqueResult())).doubleValue();
        Double avgOrdVal = ((Double) (avgOrderValue.uniqueResult())).doubleValue();
            
        stats.put("totalClients", totCli); 
        stats.put("totalOrders", totOrd);
        stats.put("maxClientsPoints", maxCliPo);
        stats.put("avgOrderValue", avgOrdVal);
             
        return stats;
	}

	@Override
	public List<POrder> viewClientPOrders(Client theClient) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
            theQuery =currentSession.createQuery("from POrder where client=:cliID", POrder.class);
        	theQuery.setParameter("cliID", theClient);
                           
        List<POrder> ordersResult = theQuery.getResultList();    
       // List<POrder> ordersResult = theClient.getPOrders();
         return ordersResult;
       // return theClient.getPOrders();
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