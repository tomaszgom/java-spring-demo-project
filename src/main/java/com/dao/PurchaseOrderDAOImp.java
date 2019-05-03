package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Client;
import com.entity.PurchaseOrder;

@Repository
public class PurchaseOrderDAOImp implements PurchaseOrderDAO {

	// Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
	
	
	@Override // In simpler version, without Service layer @Transactional could be annotated here
	public List<PurchaseOrder> getPurchaseOrders() {
		
		// Get current Hibernate session (object from Hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
		// Create a query, execute and get result list
		Query<PurchaseOrder> theQuery = currentSession.createQuery("from PurchaseOrder", PurchaseOrder.class);	
		List<PurchaseOrder> purchaseOrders = theQuery.getResultList();
		// Return the results
		return purchaseOrders;
	}


	@Override
	public List<Client> getClients() {
		// Get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
		// Create a query, execute and get result list
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);	
		List<Client> clients = theQuery.getResultList();
		// Return the results
		return clients;
	}


	@Override
	public List<Client> purchaseOrderAddSearchClients(String srchName) {
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
	
	@Override
	public void savePurchaseOrder(PurchaseOrder thePurchaseOrder) {	
		// Get Hibernate session and save client
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(thePurchaseOrder.getOrder_id() == 0) {
			// Hibernate checks if this is new object by checking if ID is empty, if so it will insert else it will update
			// CurrentSession.saveOrUpdate(theClient);
			currentSession.save(thePurchaseOrder);	
		}else{
			// Saved data as new record
			currentSession.update(thePurchaseOrder);
		}
	}
}
