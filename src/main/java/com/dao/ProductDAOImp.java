package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.entity.Product;

/**
 * 
 * @author Tomasz Gomoradzki
 * Product Data Access Object interface Implementation
 * (Some Spring notes at the end)
 *
 */

@Repository
public class ProductDAOImp implements ProductDAO {

	// Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;					   
		
	@Override // In simpler version, without Service layer @Transactional could be annotated here
	public List<Product> getProducts() {
		
		// Get current Hibernate session (object from hibernate package)
		Session currentSession = sessionFactory.getCurrentSession();		
		// Create a query, execute and get result list
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);	
		List<Product> Products = theQuery.getResultList();
		//  Return the results
		return Products;
	}

	@Override
	public void saveProduct(Product theProduct) {	
		// Get Hibernate session and save Product
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(theProduct.getProduct_id() == 0) {
			//  Hibernate checks if this is new object by checking if ID is empty, if so it will insert else it will update
			//  currentSession.saveOrUpdate(theProduct);
			currentSession.save(theProduct);	
		}else{
			// saved data as new record
			currentSession.update(theProduct);
		}
	}


	@Override
	public Product getProduct(int ProductId) {
		// Get current session and read from database
		Session currSession = sessionFactory.getCurrentSession();
		Product theProduct = currSession.get(Product.class, ProductId);
		return theProduct;
	}

	@Override
	public void deleteProduct(int ProductId) {
		// Get session, create query to delete object and exec
		Session currSession = sessionFactory.getCurrentSession();
		
		// Query theQuery = currSession.createQuery("delete from Product where Product_id=:cliID");
		// theQuery.setParameter("cliID", ProductId);
		// theQuery.executeUpdate();
		
		Query theQuery = currSession.createQuery("from Product where Product_id=:cliID");
		theQuery.setParameter("cliID", ProductId);
		Product cli= (Product)theQuery.list().get(0);
		currSession.delete(cli);
	}

	@Override
	public List<Product> searchProducts(String srchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
        // If name is not empty
        if (srchName != null && srchName.trim().length() > 0) {
            // Search by firstName or lastName
            theQuery =currentSession.createQuery("from Product where lower(firstName) like :theName or lower(lastName) like :theName", Product.class);
            theQuery.setParameter("theName", "%" + srchName.toLowerCase() + "%");          
        }else {
            theQuery =currentSession.createQuery("from Product", Product.class);            
        }
        
        List<Product> ProductsResult = theQuery.getResultList();       
        return ProductsResult;
	}
}
	
