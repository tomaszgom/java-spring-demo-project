package com.dao;
//******************
// NOTES BELOW

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Client;

@Repository
public class ClientDAOImp implements ClientDAO {

	//--Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
	
	
	
	@Override //in simpler version, without Service layer @Transactional could be annotated here
	public List<Client> getClients() {
		
		//get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query, execute and get result list
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);
	
		List<Client> clients = theQuery.getResultList();
		
		//return the results
		return clients;
	}

	@Override
	public void saveClient(Client theClient) {	
		// get Hibernate session and save client
		Session currentSession = sessionFactory.getCurrentSession();
		// saved data as new record
		currentSession.update(theClient);
		
		// hibernate checks if this is new object by checking if ID is empty, if so it will insert else it will update
		//currentSession.saveOrUpdate(theClient);
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

}


/* NOTES
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
 * @Transactional on given method thanks to which we dont have to manually start and stop session*/


//-- Code that we would normally use to start and end session, transaction
//--start transaction
//session.beginTransaction();

//Do something

//--commit transaction
//session.getTransaction().commit();