package com.dao;

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
public class POrderDAOImp implements POrderDAO {

		//  Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
	
	
	@Override //in simpler version, without Service layer @Transactional could be annotated here
	public List<POrder> getPOrders() {
		
			// Get current Hibernate session (object from Hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
			//  create a query, execute and get result list
		Query<POrder> theQuery = currentSession.createQuery("from POrder", POrder.class);	
		List<POrder> pOrders = theQuery.getResultList();
			//  return the results
		return pOrders;
	}


	@Override
	public List<Client> getClients() {
			// Get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
			//  create a query, execute and get result list
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);	
		List<Client> clients = theQuery.getResultList();
			//  return the results
		return clients;
	}


	@Override
	public List<Client> orderAddSearchClients(String srchName) {
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
	public void savePorder(POrder thePorder) {	
			// get Hibernate session and save client
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(thePorder.getOrder_id() == 0) {
				//  Hibernate checks if this is new object by checking if ID is empty, if so it will insert else it will update
				//  currentSession.saveOrUpdate(theClient);
			currentSession.save(thePorder);	
		}else{
			// saved data as new record
			currentSession.update(thePorder);
		}
	}
}
