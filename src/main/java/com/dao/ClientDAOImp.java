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
	
	
	
	@Override //in simplier version, without Service layer @Transactional could be annotated here
	public List<Client> getClients() {
		
		//get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);
		
		//execute query and get result list
		List<Client> clients = theQuery.getResultList();
		
		//return the results
		return clients;
	}



	@Override
	public void saveClient(Client theClient) {
		
		// get Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		// save client
		currentSession.save(theClient);
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